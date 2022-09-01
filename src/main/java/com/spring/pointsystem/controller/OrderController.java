package com.spring.pointsystem.controller;

import com.spring.pointsystem.exception.ApiResponseMessage;
import com.spring.pointsystem.requestDto.OrderRequestDto;
import com.spring.pointsystem.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    //현금으로 제품 주문
    @PostMapping("/api/order/cash")
    public ResponseEntity<ApiResponseMessage> orderProductByCash(@RequestBody OrderRequestDto orderRequestDto){
        orderService.orderProductByCash(orderRequestDto);
        ApiResponseMessage message = new ApiResponseMessage("Success", "제품을 구매 했습니다.", "", "");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //포인트로 제품 주문
    @PostMapping("/api/order/point")
    public ResponseEntity<ApiResponseMessage> orderProductByPoint(@RequestBody OrderRequestDto orderRequestDto){
        orderService.orderProductByPoint(orderRequestDto);
        ApiResponseMessage message = new ApiResponseMessage("Success", "제품을 구매 했습니다.", "", "");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
