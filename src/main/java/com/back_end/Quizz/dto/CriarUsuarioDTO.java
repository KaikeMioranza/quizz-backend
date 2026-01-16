package com.back_end.Quizz.dto;

import com.back_end.Quizz.entities.enums.TipoPerfil;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CriarUsuarioDTO {

    @NotNull
    Long idSso;

    String nome;

    @NotNull
    String email;

    TipoPerfil perfil;
}
