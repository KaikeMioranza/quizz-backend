package com.back_end.Quizz.controller;

import com.back_end.Quizz.dto.CriarUsuarioDTO;
import com.back_end.Quizz.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody CriarUsuarioDTO dto){
        usuarioService.cadastrarUsuario(dto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
