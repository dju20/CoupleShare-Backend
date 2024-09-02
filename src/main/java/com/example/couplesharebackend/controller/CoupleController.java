package com.example.couplesharebackend.controller;


import com.example.couplesharebackend.dto.couple.CoupleCodeRequestDto;
import com.example.couplesharebackend.dto.couple.CoupleCodeResponseDto;
import com.example.couplesharebackend.dto.couple.CouplePageResponseDto;
import com.example.couplesharebackend.dto.user.login.CustomUserDetails;
import com.example.couplesharebackend.service.couple.CoupleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/couple")
public class CoupleController {
    private final CoupleService coupleService;

    @GetMapping("/code")
    public ResponseEntity<CoupleCodeResponseDto> generateCoupleCode(
            @AuthenticationPrincipal CustomUserDetails customUserDetails) {

        try {
            String coupleCode = coupleService.generateCoupleCode(customUserDetails.getUsername());
            CoupleCodeResponseDto coupleCodeResponseDto = CoupleCodeResponseDto.builder()
                    .coupleCode(coupleCode).build();
            return ResponseEntity.ok().body(coupleCodeResponseDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/code")
    public ResponseEntity<String> matchCouple(@AuthenticationPrincipal CustomUserDetails customUserDetails, @RequestBody
    CoupleCodeRequestDto coupleCodeRequestDto) {
        try {
            coupleService.matchCouple(customUserDetails.getUsername(), coupleCodeRequestDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/page/{coupleId}")
    public ResponseEntity<CouplePageResponseDto> getCouplePage(
            @AuthenticationPrincipal CustomUserDetails customUserDetails, @PathVariable("coupleId") Long coupleId) {
        try {
            CouplePageResponseDto couplePageResponseDto = coupleService.getCouplePage(coupleId,customUserDetails.getUsername());
            return ResponseEntity.ok().body(couplePageResponseDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
