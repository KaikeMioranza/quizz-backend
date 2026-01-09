package com.back_end.Quizz.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
        name = "pergunta",
        uniqueConstraints = {
            @UniqueConstraint(
                name = "uq_ordem_pergunta",
                columnNames = {"quiz_id", "ordem"}
            )
        }
)
@Getter
@Setter
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "quiz_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_quiz")
    )
    private Quiz quiz;

    @Column(nullable = false)
    private String enunciado;

    @Column(name = "tempo_limite_segundos", nullable = false)
    private int tempoLimiteSegundos;

    @Column(nullable = false)
    private int ordem;
}
