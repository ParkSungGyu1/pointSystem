package com.spring.pointsystem.requestDto;

import lombok.Data;

@Data
public class ProductCreateRequestDto {
    private String productName;
    private int productPrice;
    private int productCount;
    private int pointRate;
    private String productOwner;
}
