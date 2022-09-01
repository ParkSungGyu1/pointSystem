package com.spring.pointsystem.requestDto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddShopBasketRequestDto {
    private String userName;
    private List<OrderListRequestDto> products;
}
