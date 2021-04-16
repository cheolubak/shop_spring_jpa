package com.shop.domain.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "order_payment",
        uniqueConstraints = {
                @UniqueConstraint(name = "order_payment_pg_id_unique", columnNames = "pg_id")
        }
)
public class OrderPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            nullable = false
    )
    private Long id;

    @Column(
            name = "pg_id",
            nullable = false
    )
    private String pgID;

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

    @OneToOne
    @JoinColumn(
            name = "order_info_id",
            foreignKey = @ForeignKey(name = "order_payment_order_info_fk"),
            nullable = false
    )
    private OrderInfo orderInfo;

    public OrderPayment() {
    }
}
