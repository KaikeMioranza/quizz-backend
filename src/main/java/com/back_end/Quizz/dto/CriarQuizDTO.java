package com.back_end.Quizz.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class CriarQuizDTO {

    @NotBlank
    private String titulo;

    private String descricao;

    private String categoria;

    @NotNull
    private Timestamp dataInicio;

    private Timestamp dataFim;

    @NotNull
    private int minimoAcertos;

    @NotNull
    private int valorCredito;

    @NotNull
    private boolean permitirRejogo;

    @NotNull
    private List<CriarPerguntaDTO> perguntas;


}
