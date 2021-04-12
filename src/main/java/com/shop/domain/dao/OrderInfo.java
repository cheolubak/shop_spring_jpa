package com.shop.domain.dao;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
public class OrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String num;

    public String buyer;

    public String name;

    public String address;

    public String addressDetail;

    public String postcode;

    public String tel;

    @CreationTimestamp
    public LocalDateTime createAt;

    @UpdateTimestamp
    public LocalDateTime updateAt;

    @OneToMany(mappedBy = "orderInfo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<OrderItem> orderItems;

    @OneToOne(mappedBy = "orderInfo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public OrderPayment payment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    public OrderInfo() {
    }
}
