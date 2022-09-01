package com.spring.pointsystem.controller;

import com.spring.pointsystem.exception.ApiResponseMessage;
import com.spring.pointsystem.requestDto.ProductCreateRequestDto;
import com.spring.pointsystem.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    //제품 생성
    @PostMapping("/api/product/create")
    public ResponseEntity<ApiResponseMessage> createProduct(@RequestBody ProductCreateRequestDto productCreateRequestDto){
        productService.createProduct(productCreateRequestDto);
        ApiResponseMessage message = new ApiResponseMessage("Success", "제품이 생성 되었습니다.", "", "");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
