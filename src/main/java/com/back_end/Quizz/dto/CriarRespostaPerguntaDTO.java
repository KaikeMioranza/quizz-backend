package com.back_end.Quizz.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriarRespostaPerguntaDTO {

    @NotNull
    private Long tentativaQuizId;

    @NotNull
    private Long perguntaId;

    @NotNull
    private Long opcaoRespostaId;

    @NotNull
    private int tempoGastoSegundos;
}
