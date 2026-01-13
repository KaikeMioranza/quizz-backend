package com.back_end.Quizz.entities;

import com.back_end.Quizz.entities.enums.TipoPerfil;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_sso", unique = true)
    private Long idSso;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column
    private TipoPerfil perfil;

    @Column(name = "data_criacao", nullable = false)
    private Timestamp dataCriacao;

    @Column(name = "ultimo_login")
    private Timestamp ultimoLogin;


}
