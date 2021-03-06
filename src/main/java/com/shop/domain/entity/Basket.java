package com.shop.domain.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            nullable = false
    )
    private Long id;

    @Column(
            name = "status",
            nullable = false,
            columnDefinition = "TINYINT(1) NOT NULL COMMENT '0: 삭제\n1: 존재\n2: 주문'"
    )
    private Integer status;

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
    @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "basket_item_fk"), nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "basket_user_fk"), nullable = false)
    private User user;
}
