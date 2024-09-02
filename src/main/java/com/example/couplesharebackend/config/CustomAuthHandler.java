package com.example.couplesharebackend.config;

import com.example.couplesharebackend.dto.user.login.CustomOAuth2User;
import com.example.couplesharebackend.jwt.JwtUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final JwtUtil jwtUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws
            IOException, ServletException {

        CustomOAuth2User customDetails = (CustomOAuth2User) authentication.getPrincipal();

        String username = customDetails.getUserName();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        GrantedAuthority auth = iterator.next();
        String role = auth.getAuthority();

        String token = jwtUtil.createJwt(username, role, 3600000L);
        Cookie cookie = createCookies("authToken", token);
        cookie.setHttpOnly(false);
        cookie.setPath("/");
        response.addCookie(cookie);

        response.sendRedirect("http://localhost:3000/redirect");

    }

    private Cookie createCookies(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(3600000);
        //cookie.setSecure(true);	//https 적용시 적용
        cookie.setPath("/");
        cookie.setHttpOnly(true);

        return cookie;
    }

}
