package com.spring.pointsystem.controller;

import com.spring.pointsystem.domain.BasketProduct;
import com.spring.pointsystem.domain.Product;
import com.spring.pointsystem.domain.ShopBasket;
import com.spring.pointsystem.domain.User;
import com.spring.pointsystem.repository.BasketProductRepository;
import com.spring.pointsystem.repository.ProductRepository;
import com.spring.pointsystem.repository.ShopBasketRepository;
import com.spring.pointsystem.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShoppingBasketControllerTest {

    @Autowired
    BasketProductRepository basketProductRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ShopBasketRepository shopBasketRepository;

    @Test
    @Transactional
    @DisplayName("장바구니 추가 테스트")
    public void addShopBasket(){
        User user = User.createUser("TestUser", 100000L, 0L);
        ShopBasket shopBasket = ShopBasket.createShopBasket(user);
        Product product1 = Product.createProduct("TestProduct", 5000, 10, 10, "TestOwner");
        BasketProduct basketProduct = BasketProduct.addShoppingBasket(shopBasket, product1, 3);

        assertEquals(basketProduct.getProduct().getProductName(),"TestProduct");
        assertEquals(basketProduct.getShopBasket().getUser().getUserName(),"TestUser");
    }
}