package com.spring.pointsystem.requestDto;

import lombok.*;

@Data
public class UserCreateRequestDto {
    private String userName;
    private Long userCash;
    private Long userPoint;
}
