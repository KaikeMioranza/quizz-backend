package com.back_end.Quizz.entities;

import jakarta.persistence.*;

@Entity
@Table(
        name = "opcao_resposta",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uq_ordem_opcao",
                        columnNames = {"pergunta_id","ordem"}
                )
        }
)
public class OpcaoResposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(
            name = "pergunta_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "pergunta_id")
    )
    private Pergunta pergunta;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Boolean correta;

    @Column(nullable = false)
    private int ordem;
}
