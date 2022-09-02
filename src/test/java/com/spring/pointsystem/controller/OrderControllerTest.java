package com.spring.pointsystem.controller;

import com.spring.pointsystem.domain.OrderList;
import com.spring.pointsystem.domain.Product;
import com.spring.pointsystem.domain.User;
import com.spring.pointsystem.repository.OrderRepository;
import com.spring.pointsystem.repository.ProductRepository;
import com.spring.pointsystem.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderControllerTest {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;

    @Test
    @Transactional
    @DisplayName("단건 현금 주문 생성 테스트")
    public void createOneOrderByCash(){
        System.out.println("## 단건 현금 주문 생성 시작");
        System.out.println();

        User user = User.createUser("TestUser", 100000L, 0L);
        Product product = Product.createProduct("TestProduct", 5000, 10, 10, "TestOwner");

        OrderList.orderProductsByCash(user, product, 2);

        assertEquals(user.getUserCash(),90000L);
        assertEquals(user.getUserPoint(),1000L);
        assertEquals(product.getProductCount(),8);

    }

    @Test
    @Transactional
    @DisplayName("다건 현금 주문 생성 테스트")
    public void createManyOrderByCash(){
        System.out.println("## 다건 현금 주문 생성 시작");
        System.out.println();

        User user = User.createUser("TestUser", 100000L, 0L);
        Product product1 = Product.createProduct("TestProduct", 5000, 10, 10, "TestOwner");
        Product product2 = Product.createProduct("TestProduct", 10000, 10, 20, "TestOwner2");


        OrderList.orderProductsByCash(user, product1, 2);
        OrderList.orderProductsByCash(user, product2, 3);

        assertEquals(user.getUserCash(),60000L);
        assertEquals(user.getUserPoint(),7000L);
        assertEquals(product1.getProductCount(),8);
        assertEquals(product2.getProductCount(),7);

    }

    @Test
    @Transactional
    @DisplayName("단건 포인트 주문 생성 테스트")
    public void createOneOrderByPoint(){
        System.out.println("## 단건 포인트 주문 생성 시작");
        System.out.println();

        User user = User.createUser("TestUser", 100000L, 100000L);
        Product product = Product.createProduct("TestProduct", 5000, 10, 10, "TestOwner");

        OrderList.orderProductsByPoint(user, product, 2);

        assertEquals(user.getUserCash(),100000L);
        assertEquals(user.getUserPoint(),90000L);
        assertEquals(product.getProductCount(),8);

    }

    @Test
    @Transactional
    @DisplayName("다건 포인트 주문 생성 테스트")
    public void createManyOrderByPoint(){
        System.out.println("## 다건 포인트 주문 생성 시작");
        System.out.println();

        User user = User.createUser("TestUser", 100000L, 100000L);
        Product product1 = Product.createProduct("TestProduct", 5000, 10, 10, "TestOwner");
        Product product2 = Product.createProduct("TestProduct", 10000, 10, 20, "TestOwner2");


        OrderList.orderProductsByPoint(user, product1, 2);
        OrderList.orderProductsByPoint(user, product2, 3);

        assertEquals(user.getUserCash(),100000L);
        assertEquals(user.getUserPoint(),60000L);
        assertEquals(product1.getProductCount(),8);
        assertEquals(product2.getProductCount(),7);

    }
    @Test
    @Transactional
    @DisplayName("주문 예외처리")
    public void orderExceptions(){
        System.out.println("## 주문 예외처리 시작");
        System.out.println();

        User user1 = User.createUser("TestUser", 100000L, 100000L);
        User user2 = User.createUser("TestUser", 100L, 100L);
        Product product1 = Product.createProduct("TestProduct", 5000, 10, 10, "TestOwner");
        Product product2 = Product.createProduct("TestProduct", 10000, 10, 20, "TestOwner2");

        IllegalArgumentException e1 = assertThrows(IllegalArgumentException.class,
                () -> OrderList.orderProductsByPoint(user1, product1, 90000));

        IllegalArgumentException e2 = assertThrows(IllegalArgumentException.class,
                () -> OrderList.orderProductsByCash(user2, product1, 3));

        IllegalArgumentException e3 = assertThrows(IllegalArgumentException.class,
                () -> OrderList.orderProductsByPoint(user2, product2, 3));

        assertEquals(e1.getMessage(), "제품 개수가 부족합니다.");
        assertEquals(e2.getMessage(), "요금이 부족합니다.");
        assertEquals(e3.getMessage(), "포인트가 부족합니다.");
    }

}