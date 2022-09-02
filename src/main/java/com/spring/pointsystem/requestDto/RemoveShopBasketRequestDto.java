package com.spring.pointsystem.requestDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoveShopBasketRequestDto {
    private Long userId;
    private Long productId;
}
