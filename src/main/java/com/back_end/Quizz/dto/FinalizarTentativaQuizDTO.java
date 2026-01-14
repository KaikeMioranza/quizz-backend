package com.back_end.Quizz.dto;

import com.back_end.Quizz.entities.enums.StatusQuiz;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public class FinalizarTentativaQuizDTO {

    @NotNull
    private Timestamp dataFim;

    @NotNull
    private StatusQuiz status;

    @NotNull
    private int totalAcertos;

    @NotNull
    private int totalPulos;

    @NotNull
    private Boolean aprovado;

    @NotNull
    private Boolean creditoGerado;


}
