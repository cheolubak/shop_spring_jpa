package com.shop.domain.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(
        name = "review"
)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            nullable = false
    )
    private Long id;

    @Column(
            name = "title",
            nullable = false
    )
    private String title;

    @Column(
            name = "description",
            nullable = false
    )
    private String description;

    @Column(
            name = "is_delete",
            nullable = false
    )
    private Boolean isDelete;

    @CreationTimestamp
    @Column(
            name = "created_at",
            nullable = false
    )
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(
            name = "updated_at",
            nullable = false
    )
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "review_user_id_fk"),
            nullable = false
    )
    private User user;

    @OneToOne
    @JoinColumn(
            name = "order_item_id",
            foreignKey = @ForeignKey(name = "review_order_item_id_fk"),
            nullable = false
    )
    private OrderItem orderItem;

    @OneToMany(
            mappedBy = "review",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Set<ReviewImage> reviewImages;
}
