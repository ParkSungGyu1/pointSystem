package com.spring.pointsystem.repository;

import com.spring.pointsystem.domain.ShopBasket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopBasketRepository extends JpaRepository<ShopBasket, Long> {
    ShopBasket findByUserId(Long userId);
}
