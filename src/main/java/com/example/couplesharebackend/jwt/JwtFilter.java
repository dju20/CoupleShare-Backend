package com.example.couplesharebackend.jwt;

import com.example.couplesharebackend.dto.user.login.CustomUserDetails;
import com.example.couplesharebackend.entity.User;
import com.example.couplesharebackend.enums.user.UserRole;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
		FilterChain filterChain) throws ServletException, IOException {
		String authorization = request.getHeader("Authorization");
		String token = null;

		if(authorization==null){
			token = Optional.ofNullable(request.getCookies())
				.flatMap(cookies -> Arrays.stream(cookies)
					.filter(cookie -> "Authorization".equals(cookie.getName()))
					.map(cookie -> cookie.getValue())
					.findFirst())
				.orElse(null);
		}
		else if(authorization != null || authorization.startsWith("Bearer ")){
			token = authorization.split(" ")[1];
		}


		if (token == null || jwtUtil.isExpired(token)) {
			System.out.println("token null or expired");
			filterChain.doFilter(request, response);
			return;
		}


		if(jwtUtil.isExpired(token)){
			System.out.println("token expired");
			filterChain.doFilter(request,response);


			return;
		}

		String username = jwtUtil.getUsername(token);
		String role = jwtUtil.getRole(token);

		User userData = User.builder()
			.username(username)
			.role(UserRole.valueOf(role))
			.build();

		CustomUserDetails customUserDetails = new CustomUserDetails(userData);

		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
			customUserDetails, null, customUserDetails.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(authToken);
		System.out.println(username+" pass filter");
		filterChain.doFilter(request,response);
	}
}
