package com.shop.domain.entity;

import com.shop.domain.enums.QuestionType;

import javax.persistence.*;

@Entity
@Table(
        name = "question_mapping",
        indexes = {
                @Index(name = "question_mapping_target_id_index", columnList = "target_id")
        }
)
public class QuestionMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private QuestionType type;

    @Column(name = "target_id")
    private Long targetId;

    @OneToOne
    @JoinColumn(
            name = "question_id",
            foreignKey = @ForeignKey(name = "question_mapping_question_id_fk"),
            nullable = false
    )
    private Question question;
}
