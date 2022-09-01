package com.spring.pointsystem.service;

import com.spring.pointsystem.domain.Product;
import com.spring.pointsystem.repository.ProductRepository;
import com.spring.pointsystem.requestDto.ProductCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public void createProduct(ProductCreateRequestDto productCreateRequestDto){
        Product product = Product.createProduct(
                productCreateRequestDto.getProductName(),
                productCreateRequestDto.getProductPrice(),
                productCreateRequestDto.getProductCount(),
                productCreateRequestDto.getPointRate(),
                productCreateRequestDto.getProductOwner()
        );
        productRepository.save(product);
    }
}
