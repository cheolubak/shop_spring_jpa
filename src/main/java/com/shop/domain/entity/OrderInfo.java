package com.shop.domain.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class OrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String num;

    private String buyer;

    private String name;

    private String address;

    private String addressDetail;

    private String postcode;

    private String tel;

    @CreationTimestamp
    private LocalDateTime createAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "orderInfo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItems;

    @OneToOne(mappedBy = "orderInfo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private OrderPayment payment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public OrderInfo() {
    }
}
