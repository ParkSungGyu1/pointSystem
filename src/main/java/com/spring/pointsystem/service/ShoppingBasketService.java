package com.spring.pointsystem.service;

import com.spring.pointsystem.repository.ShoppingBasketRepository;
import com.spring.pointsystem.requestDto.AddShopBasketRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingBasketService  {

    private final ShoppingBasketRepository shoppingBasketRepository;

    public void addShopBasket(AddShopBasketRequestDto addShopBasketRequestDto) {

    }
}
