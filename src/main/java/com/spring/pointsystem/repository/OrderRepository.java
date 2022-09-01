package com.spring.pointsystem.repository;

import com.spring.pointsystem.domain.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderList, Long> {
}
