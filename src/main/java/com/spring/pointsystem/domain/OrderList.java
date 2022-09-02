package com.spring.pointsystem.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderList_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    //== 생성 메서드 ==//

    //현금 주문 생성
    public static OrderList orderProductsByCash(User user, Product product, int count){
        OrderList orderList = new OrderList();
        user.useCash(product.getProductPrice(), product.countProductPoint(), count);
        product.deductionCount(count);
        orderList.settingOrder(user, product);
        return orderList;
    }

    //포인트 주문 생성
    public static OrderList orderProductsByPoint(User user, Product product, int count){
        OrderList orderList = new OrderList();
        user.usePoint(product.getProductPrice(),count);
        product.deductionCount(count);
        orderList.settingOrder(user, product);
        return orderList;
    }

    //주문 세터 메서드
    public void settingOrder(User user, Product product){
        this.user = user;
        this.product = product;
    }
    //== 비즈니스 로직 ==//

}
