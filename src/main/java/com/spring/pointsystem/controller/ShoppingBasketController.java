package com.spring.pointsystem.controller;

import com.spring.pointsystem.exception.ApiResponseMessage;
import com.spring.pointsystem.requestDto.AddShopBasketRequestDto;
import com.spring.pointsystem.service.ShoppingBasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShoppingBasketController {

    private final ShoppingBasketService shoppingBasketService;

    //장바구니 담기
   @PostMapping("/api/shopBasket/add")
    public ResponseEntity<ApiResponseMessage> addShopBasket(@RequestBody AddShopBasketRequestDto addShopBasketRequestDto){
       shoppingBasketService.addShopBasket(addShopBasketRequestDto);
       ApiResponseMessage message = new ApiResponseMessage("Success", "장바구니 담기 완료", "", "");
       return new ResponseEntity<>(message, HttpStatus.OK);
   }
}
