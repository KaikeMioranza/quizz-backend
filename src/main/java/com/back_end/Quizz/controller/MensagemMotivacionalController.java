package com.back_end.Quizz.controller;


import com.back_end.Quizz.dto.CriarAvisoImportanteDTO;
import com.back_end.Quizz.dto.CriarMensagemDTO;
import com.back_end.Quizz.entities.AvisoImportante;
import com.back_end.Quizz.entities.MensagemMotivacional;
import com.back_end.Quizz.service.MensagemMotivacionalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/mensagemmotivacional")
public class MensagemMotivacionalController {

    @Autowired
    private MensagemMotivacionalService mensagemMotivacionalService;

    @PostMapping
    public ResponseEntity<Void> CriarMensagem(@RequestBody @Valid CriarMensagemDTO dto) {

        mensagemMotivacionalService.CriarMensagemMotivacional(dto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public Optional<MensagemMotivacional> BuscarMensagem() {
        return  mensagemMotivacionalService.BuscarMensagem();
    }

}
