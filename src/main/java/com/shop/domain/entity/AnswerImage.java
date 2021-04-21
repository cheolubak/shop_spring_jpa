package com.shop.domain.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "answer_image"
)
public class AnswerImage {
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
    private String isDelete;

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
            name = "answer_id",
            foreignKey = @ForeignKey(name = "answer_image_answer_id_fk"),
            nullable = false
    )
    private Answer answer;
}
