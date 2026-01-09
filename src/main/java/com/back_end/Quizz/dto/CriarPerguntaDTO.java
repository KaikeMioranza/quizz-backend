package com.back_end.Quizz.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CriarPerguntaDTO {

    @NotNull
    private String enunciado;

    @NotNull
    private int tempoLimiteSegundos;

    @NotNull
    private int ordem;

    @NotNull
    private List<CriarOpcaoRespostaDTO> opcoes;
}
