package com.back_end.Quizz.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String titulo;

    @Column
    private String descricao;

    @Column(length = 100)
    private String categoria;

    @Column(name = "data_inicio", nullable = false)
    private Timestamp dataInicio;

    @Column(name = "data_fim")
    private Timestamp dataFim;

    @Column(name = "minimo_acertos", nullable = false)
    private int minimoAcertos;

    @Column(name = "valor_credito", nullable = false)
    private int valorCredito;

    @Column(name = "permitir_rejogo", nullable = false)
    private Boolean permitirRejogo;

}
