package com.spring.pointsystem.service;

import com.spring.pointsystem.domain.OrderList;
import com.spring.pointsystem.domain.Product;
import com.spring.pointsystem.domain.User;
import com.spring.pointsystem.repository.OrderRepository;
import com.spring.pointsystem.repository.ProductRepository;
import com.spring.pointsystem.repository.UserRepository;
import com.spring.pointsystem.requestDto.OrderListRequestDto;
import com.spring.pointsystem.requestDto.OrderRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    @Transactional
    public void orderProductByCash(OrderRequestDto orderRequestDto) {
        User user = userRepository.findByUserName(orderRequestDto.getUserName());
        List<OrderListRequestDto> products = orderRequestDto.getProducts();
        for (OrderListRequestDto product : products) {
            Product byProductName = productRepository.findByProductName(product.getProductName());
            OrderList orderList = OrderList.orderProductsByCash(user,byProductName, product.getProductCount());
            orderRepository.save(orderList);
        }
    }

    @Transactional
    public void orderProductByPoint(OrderRequestDto orderRequestDto) {

    }
}
