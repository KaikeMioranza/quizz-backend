package com.back_end.Quizz.entities;

import com.back_end.Quizz.entities.enums.Severidade;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;


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

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Severidade severidade;

    @Column(name = "data_inicio",nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    @Column
    private Boolean ativo;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;


}
