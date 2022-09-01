package com.spring.pointsystem.requestDto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {
    private String userName;
    private List<OrderListRequestDto> products;
}
