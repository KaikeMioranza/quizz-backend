package com.back_end.Quizz.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class CriarTentativaQuizDTO {

    @NotNull
    private Long quizId;

    @NotNull
    private Long usuarioId;


}
