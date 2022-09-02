package com.spring.pointsystem.controller;

import com.spring.pointsystem.exception.ApiResponseMessage;
import com.spring.pointsystem.requestDto.AddShopBasketRequestDto;
import com.spring.pointsystem.requestDto.RemoveShopBasketRequestDto;
import com.spring.pointsystem.service.ShoppingBasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

   //장바구니 빼기
    @DeleteMapping("/api/shopBasket/remove")
    public ResponseEntity<ApiResponseMessage> removeShopBasket(@RequestBody RemoveShopBasketRequestDto removeShopBasketRequestDto){
        shoppingBasketService.removeShopBasket(removeShopBasketRequestDto);
        ApiResponseMessage message = new ApiResponseMessage("Success", "장바구니 제거 완료", "", "");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
