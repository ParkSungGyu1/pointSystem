package com.spring.pointsystem.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BasketProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basketProduct_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "shopBasket_id")
    private ShopBasket shopBasket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    private int totalPrice;

    @Column
    private int count;

    //== 생성 메서드 ==//
    //장바구니 생성
    public static BasketProduct addShoppingBasket(ShopBasket shopBasket, Product product, int count){
        BasketProduct basketProduct = new BasketProduct();
        basketProduct.settingShoppingBasket(shopBasket,product);
        basketProduct.countTotalPrice(count, product.getProductPrice());
        return basketProduct;
    }

    //장바구니 세터 메서드
    public void settingShoppingBasket(ShopBasket shopBasket, Product product){
        this.shopBasket = shopBasket;
        this.product = product;
    }

    //== 비즈니스 로직 ==//
    //개수 입력 및 금액 산출
    public void countTotalPrice(int count, int price){
        this.count = count;
        this.totalPrice = price * count;
    }

}
