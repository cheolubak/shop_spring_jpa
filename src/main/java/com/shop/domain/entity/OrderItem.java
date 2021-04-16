package com.shop.domain.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            nullable = false
    )
    private Long id;

    @CreationTimestamp
    @Column(
            name = "create_at",
            nullable = false
    )
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(
            name = "update_at",
            nullable = false
    )
    private LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(
            name = "item_id",
            foreignKey = @ForeignKey(name = "order_item_item_fk"),
            nullable = false
    )
    private Item item;

    @ManyToOne
    @JoinColumn(
            name = "order_info_id",
            foreignKey = @ForeignKey(name = "order_item_order_info_fk"),
            nullable = false
    )
    private OrderInfo orderInfo;

    public OrderItem() {
    }
}
