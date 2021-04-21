package com.shop.domain.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ReviewImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            nullable = false
    )
    private Long id;

    @Column(
            name = "url",
            nullable = false
    )
    private String url;

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
            name = "review_id",
            foreignKey = @ForeignKey(name = "review_image_review_id_fk"),
            nullable = false
    )
    private Review review;
}
