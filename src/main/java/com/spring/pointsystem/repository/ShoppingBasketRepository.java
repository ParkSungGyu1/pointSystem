package com.spring.pointsystem.repository;

import com.spring.pointsystem.domain.ShopBasket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingBasketRepository extends JpaRepository<ShopBasket, Long> {
}
