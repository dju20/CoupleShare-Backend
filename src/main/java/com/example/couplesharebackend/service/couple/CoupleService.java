package com.example.couplesharebackend.service.couple;


import com.example.couplesharebackend.dto.couple.CoupleCodeRequestDto;
import com.example.couplesharebackend.dto.couple.CouplePageResponseDto;

public interface CoupleService {

    String generateCoupleCode(String username);

    void matchCouple(String username, CoupleCodeRequestDto coupleCodeRequestDto);

    CouplePageResponseDto getCouplePage(Long coupleId, String username);
}
