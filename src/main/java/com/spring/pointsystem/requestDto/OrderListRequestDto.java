package com.spring.pointsystem.requestDto;

import lombok.Data;

@Data
public class OrderListRequestDto {
    private String productName;
    private int productCount;
}
