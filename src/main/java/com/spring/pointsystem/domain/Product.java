package com.spring.pointsystem.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private int productPrice;

    @Column(nullable = false)
    private int productCount;

    @Column(nullable = false)
    private int pointRate;

    @Column(nullable = false)
    private String productOwner;

    //== 생성 메서드 ==//

    //제품 생성
    public static Product createProduct(String productName, int productPrice, int productCount, int pointRate, String productOwner){
        Product product = new Product();
        product.settingProduct(productName,productPrice,productCount,pointRate,productOwner);
        return product;
    }

    //제품 세터 메서드
    private void settingProduct(String productName, int productPrice, int productCount, int pointRate, String productOwner) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCount = productCount;
        this.pointRate = pointRate;
        this.productOwner = productOwner;
    }

    //== 비즈니스 로직 ==//

    //포인트 비율 계산
    public int countProductPoint(){
        return (this.productPrice * this.pointRate) / 100;
    }

    //제품개수 차감
    public void deductionCount(int count){
        if(this.productCount < count){
            throw new IllegalArgumentException("제품 개수가 부족합니다.");
        }else {
            this.productCount -= count;
        }
    }
}
