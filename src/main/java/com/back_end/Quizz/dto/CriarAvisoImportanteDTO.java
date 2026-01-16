package com.back_end.Quizz.dto;

import com.back_end.Quizz.entities.enums.Severidade;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
public class CriarAvisoImportanteDTO {

    @NotNull
    String titulo;

    @NotNull
    String mensagem;

    @NotNull
    Severidade severidade;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    Timestamp dataInicio;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    Timestamp dataFim;
}
