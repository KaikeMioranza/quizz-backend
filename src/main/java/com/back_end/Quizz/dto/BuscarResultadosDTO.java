package com.back_end.Quizz.dto;

import jakarta.validation.constraints.NotNull;

public class BuscarResultadosDTO {

    @NotNull
    int countQuizzes;
    @NotNull
    int countTempo;
    @NotNull
    int countAcertos;
}
