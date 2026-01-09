package com.back_end.Quizz.entities;

import com.back_end.Quizz.entities.enums.StatusPergunta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "tentativa_quiz")
@Getter
@Setter
public class TentativaQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "quiz_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_quiz")
    )
    private Quiz quiz;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "usuario_id",
            nullable=false,
            foreignKey = @ForeignKey(name = "fk_usuario")
    )
    private Usuario usuario;

    @Column(name = "data_inicio", nullable = false)
    private Timestamp dataInicio;

    @Column(name= "data_fim")
    private Timestamp dataFim;

    @Column(length = 20, nullable = false)
    private StatusPergunta status;

    @Column(name = "total_acertos")
    private int totalAcertos;

    @Column(name = "total_erros")
    private int totalErros;

    @Column(name = "total_pulos")
    private int totalPulos;

    @Column
    private Boolean aprovado;

    @Column(name = "credito_gerado", nullable = false)
    private Boolean creditoGerado ;


}
