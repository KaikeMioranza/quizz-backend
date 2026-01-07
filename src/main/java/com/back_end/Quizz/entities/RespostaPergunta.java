package com.back_end.Quizz.entities;


import jakarta.persistence.*;
import jakarta.validation.Constraint;

import java.sql.Timestamp;

@Entity
@Table(
        name = "resposta_pergunta",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "uq_resposta_unica",
                    columnNames = {"tentativa_quiz_id","pergunta_id"}
            )
        }
)
public class RespostaPergunta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "tentativa_quiz_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_resposta_tentativa")
    )
    private Quiz quiz;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "pergunta_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_resposta_pergunta")
    )
    private Pergunta pergunta;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(
            name = "opcao_resposta_id",
            foreignKey = @ForeignKey(name = "opcao_resposta_id")
    )
    private OpcaoResposta opcaoResposta;

    @Column(name = "tempo_gasto_segundos", nullable = false)
    private int tempoGastoSegundos;

    @Column
    private Boolean correta;

    @Column(name = "data_resposta")
    private Timestamp dataResposta;


}
