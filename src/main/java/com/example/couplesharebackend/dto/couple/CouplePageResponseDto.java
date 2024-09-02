package com.example.couplesharebackend.dto.couple;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CouplePageResponseDto {
    private Long coupleId;
    private String user1Username;
    private String user2Username;
    private boolean canEdit;
}
