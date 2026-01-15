package com.back_end.Quizz.dto;

import com.back_end.Quizz.entities.enums.StatusQuiz;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BuscarTentativaQuizDTO {

    @NotNull
    private Long usuarioId;


    private StatusQuiz status;
}
