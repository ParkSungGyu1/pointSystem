package com.spring.pointsystem.service;

import com.spring.pointsystem.domain.BasketProduct;
import com.spring.pointsystem.domain.Product;
import com.spring.pointsystem.domain.ShopBasket;
import com.spring.pointsystem.domain.User;
import com.spring.pointsystem.repository.BasketProductRepository;
import com.spring.pointsystem.repository.ProductRepository;
import com.spring.pointsystem.repository.ShopBasketRepository;
import com.spring.pointsystem.repository.UserRepository;
import com.spring.pointsystem.requestDto.AddShopBasketRequestDto;
import com.spring.pointsystem.requestDto.OrderListRequestDto;
import com.spring.pointsystem.requestDto.RemoveShopBasketRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingBasketService  {

    private final BasketProductRepository basketProductRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ShopBasketRepository shopBasketRepository;

    //장바구니 추가
    @Transactional
    public void addShopBasket(AddShopBasketRequestDto addShopBasketRequestDto) {
        User user = userRepository.findByUserName(addShopBasketRequestDto.getUserName());
        ShopBasket shopBasket = ShopBasket.createShopBasket(user);
        List<OrderListRequestDto> products = addShopBasketRequestDto.getProducts();
        for (OrderListRequestDto product : products) {
            Product byProductName = productRepository.findByProductName(product.getProductName());
            BasketProduct basketProduct = BasketProduct.addShoppingBasket(shopBasket, byProductName, product.getProductCount());
            basketProductRepository.save(basketProduct);
        }
    }

    //장바구니 삭제
    @Transactional
    public void removeShopBasket(RemoveShopBasketRequestDto removeShopBasketRequestDto){
        ShopBasket byUserId = shopBasketRepository.findByUserId(removeShopBasketRequestDto.getUserId());
        basketProductRepository.deleteAllByShopBasketAndProductId(byUserId, removeShopBasketRequestDto.getProductId());
    }
}
