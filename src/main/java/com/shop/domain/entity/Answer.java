package com.shop.domain.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(
        name = "answer"
)
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            nullable = false
    )
    private Long id;

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
            foreignKey = @ForeignKey(name = "answer_user_id_fk"),
            nullable = false
    )
    private User user;

    @OneToMany(
            mappedBy = "answer",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Set<AnswerImage> answerImages;
}
