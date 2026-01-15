package com.back_end.Quizz.controller;


import com.back_end.Quizz.dto.CriarAvisoImportanteDTO;
import com.back_end.Quizz.dto.CriarMensagemDTO;
import com.back_end.Quizz.service.MensagemMotivacionalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
