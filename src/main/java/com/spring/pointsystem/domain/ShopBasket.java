package com.spring.pointsystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShopBasket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopBasket_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

     //== 생성 메서드 ==//
    //장바구니 생성
    public static ShopBasket createShopBasket(User user){
        ShopBasket shopBasket = new ShopBasket();
        shopBasket.settingShopBasket(user);
        return shopBasket;
    }
    //장바구니 세터 메서드
    public void settingShopBasket(User user){
        this.user = user;
        user.settingShopBasket(this);
    }
}
