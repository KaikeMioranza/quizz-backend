package com.back_end.Quizz.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriarOpcaoRespostaDTO {

    @NotNull
    private String descricao;

    @NotNull
    private Boolean correta;

    @NotNull
    private int ordem;
}
