package com.shop.domain.dao;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @CreationTimestamp
    public LocalDateTime createAt;

    @UpdateTimestamp
    public LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "item_id")
    public Item item;

    @ManyToOne
    @JoinColumn(name = "order_info_id")
    public OrderInfo orderInfo;
}
