package com.shop.domain.dao;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public Integer status;

    @CreationTimestamp
    public LocalDateTime createAt;

    @UpdateTimestamp
    public LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "item_id")
    public Item item;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;
}
