package com.spring.pointsystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ShopBasket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopBasket_id")
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy = "shopBasket", fetch = FetchType.LAZY)
    private User user;
}
