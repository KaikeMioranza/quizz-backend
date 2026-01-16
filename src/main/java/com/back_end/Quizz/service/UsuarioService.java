package com.back_end.Quizz.service;

import com.back_end.Quizz.dto.CriarUsuarioDTO;
import com.back_end.Quizz.entities.Usuario;
import com.back_end.Quizz.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(CriarUsuarioDTO dto) {

        Timestamp agora = Timestamp.from(Instant.now());

        Usuario u = new Usuario();
        u.setIdSso(dto.getIdSso());
        u.setNome(dto.getNome());
        u.setEmail(dto.getEmail());
        u.setDataCriacao(agora);

        return usuarioRepository.save(u);
    }

}
