package com.example.couplesharebackend.entity;

import com.example.couplesharebackend.enums.user.CoupleStatus;
import com.example.couplesharebackend.enums.user.Sex;
import com.example.couplesharebackend.enums.user.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    @Enumerated(EnumType.STRING)
    private Sex sex;

    private String password;
    private String realName;
    private String profileImg;
    private String email;
    private String provider;
    private String providerId;
    @Enumerated(EnumType.STRING)
    private CoupleStatus coupleStatus;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public void changeCoupleStatusToWAIT() {
        this.coupleStatus = CoupleStatus.WAIT;
    }

    public void changeCoupleStatusToCouple() {
        this.coupleStatus = CoupleStatus.COUPLE;
    }

    public void changeCoupleStatusToSolo() {
        this.coupleStatus = CoupleStatus.SOLO;
    }

    // @Builder
    // public User(String username, Sex sex, String password, String realName, String profileImg, String email, String provider, String providerId, Boolean isCouple, UserRole role) {
    // 	this.username = username;
    // 	this.sex = sex;
    // 	this.password = password;
    // 	this.realName = realName;
    // 	this.profileImg = profileImg;
    // 	this.email = email;
    // 	this.provider = provider;
    // 	this.providerId = providerId;
    // 	this.isCouple = isCouple;
    // 	this.role = role;
    // }


}
