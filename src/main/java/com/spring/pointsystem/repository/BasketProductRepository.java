package com.spring.pointsystem.repository;

import com.spring.pointsystem.domain.BasketProduct;
import com.spring.pointsystem.domain.ShopBasket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketProductRepository extends JpaRepository<BasketProduct, Long> {
    void deleteAllByShopBasketAndProductId(ShopBasket shopBasket, Long productId);
}
