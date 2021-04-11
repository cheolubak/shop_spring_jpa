package com.shop.domain.dao;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ItemImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String path;

    public Boolean isdelete;

    @CreationTimestamp
    public LocalDateTime createAt;

    @UpdateTimestamp
    public LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "item_id")
    public Item item;
}
