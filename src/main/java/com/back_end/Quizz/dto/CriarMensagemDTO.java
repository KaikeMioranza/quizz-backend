package com.back_end.Quizz.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
public class CriarMensagemDTO {

    @NotNull
    String mensagem;

    @NotNull
    Timestamp dataInicio;

    @NotNull
    Timestamp dataFim;


}
