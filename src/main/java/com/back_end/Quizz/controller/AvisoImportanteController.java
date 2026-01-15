package com.back_end.Quizz.controller;

import com.back_end.Quizz.dto.CriarAvisoImportanteDTO;
import com.back_end.Quizz.entities.AvisoImportante;
import com.back_end.Quizz.service.AvisoImportanteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avisoimportante")
public class AvisoImportanteController {

    @Autowired
    AvisoImportanteService avisoImportanteService;
    @PostMapping
    public ResponseEntity<Void> CriarAviso(@RequestBody @Valid CriarAvisoImportanteDTO dto) {
        avisoImportanteService.CriarAvisoImportante(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<AvisoImportante> BuscarAvisos() {
        return  avisoImportanteService.BuscarAvisos();
    }
}
