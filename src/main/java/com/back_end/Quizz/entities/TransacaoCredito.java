package com.back_end.Quizz.entities;


import com.back_end.Quizz.entities.enums.TipoTransacao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "transacaco_credito")
@Getter
@Setter
public class TransacaoCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "usuario_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_usuario")
    )
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(
            name = "tentativa_quiz_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_tentativa_quiz")
    )
    private TentativaQuiz tentativaQuiz;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(length = 20, nullable = false)
    private TipoTransacao tipo;

    @Column(name = "data_criacao", nullable = false)
    private Timestamp dataCriacao;


}
