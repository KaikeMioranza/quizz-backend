package com.back_end.Quizz.entities;

import com.back_end.Quizz.entities.enums.Severidade;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "aviso_importante")
@Getter
@Setter
public class AvisoImportante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String titulo;

    @Column( nullable = false)
    private String mensagem;

    @Column(length = 20, nullable = false)
    private Severidade severidade;

    @Column(name = "data_inicio",nullable = false)
    private Timestamp dataInicio;

    @Column(name = "data_fim")
    private Timestamp dataFim;

    @Column
    private Boolean ativo;

    @Column(name = "data_criacao", nullable = false)
    private Timestamp dataCriacao;


}
