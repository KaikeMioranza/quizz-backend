package com.back_end.Quizz.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name= "log_acesso_usuario")
@Getter
@Setter
public class LogAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "usuario_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_usuario")
    )
    private Usuario usuario;

    @Column(name="data_login", nullable = false)
    private Timestamp dataLogin;

    @Column(length = 50)
    private String ip;

    @Column(length = 100)
    private String dispositivo;
}
