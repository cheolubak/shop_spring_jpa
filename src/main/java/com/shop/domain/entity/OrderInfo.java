package com.shop.domain.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(
        name = "order_info",
        uniqueConstraints = {
                @UniqueConstraint(name = "order_info_num_unique", columnNames = {"num"})
        }
)
public class OrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            nullable = false
    )
    private Long id;

    @Column(
            name = "num",
            nullable = false,
            columnDefinition = "VARCHAR(20) NOT NULL COMMENT '주문번호'"
    )
    private String num;

    @Column(
            name = "buyer",
            nullable = false
    )
    private String buyer;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "VARCHAR(20) NOT NULL COMMENT '주문명'"
    )
    private String name;

    @Column(
            name = "address",
            nullable = false
    )
    private String address;

    @Column(
            name = "address_detail",
            nullable = true
    )
    private String addressDetail;

    @Column(
            name = "postcode",
            nullable = false,
            length = 6
    )
    private String postcode;

    @Column(
            name = "tel",
            nullable = false,
            length = 11
    )
    private String tel;

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
            name = "user_id",
            foreignKey = @ForeignKey(name = "order_info_user_fk"),
            nullable = false
    )
    private User user;

    @OneToMany(
            mappedBy = "orderInfo",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Set<OrderItem> orderItems;

    @OneToOne(
            mappedBy = "orderInfo",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private OrderPayment payment;

    public OrderInfo() {
    }
}
