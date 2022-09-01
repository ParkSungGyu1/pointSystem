package com.spring.pointsystem.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private Long userCash;

    @Column(nullable = false)
    private Long userPoint;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "shopBasket_id")
    private BasketProduct basketProduct;

    //== 생성 메서드 ==//

    //유저 생성
    public static User createUser(String userName, Long userCash, Long userPoint){
        User user = new User();
        user.userSetting(userName,userCash,userPoint);
        return user;
    }

    //유저 세터 메서드
    public void userSetting(String userName, Long userCash, Long userPoint){
        this.userName = userName;
        this.userCash = userCash;
        this.userPoint = userPoint;
    }

    //== 비즈니스 로직 ==//
    //현금 차감 후 포인트 적립
    public void useCash(int fee, int point, int count){
        if (this.userCash < fee * count){
            throw new IllegalArgumentException("요금이 부족합니다.");
        }else{
            this.userCash -= fee * count;
            this.userPoint += point;
        }
    }
    //포인트 차감
    public void usePoint(int fee){
        if(this.userPoint < fee){
            throw new IllegalArgumentException("포인트가 부족합니다.");
        }else{
            this.userPoint -= fee;
        }
    }
}
