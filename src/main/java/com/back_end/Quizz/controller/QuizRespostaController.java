package com.back_end.Quizz.controller;

import com.back_end.Quizz.dto.CriarRespostaPerguntaDTO;
import com.back_end.Quizz.dto.CriarTentativaQuizDTO;
import com.back_end.Quizz.service.RespostaQuizService;
import com.back_end.Quizz.service.TentativaQuizService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quizresposta")
public class QuizRespostaController {
    private final RespostaQuizService respostaQuizService;

    public QuizRespostaController(RespostaQuizService respostaQuizService) {
        this.respostaQuizService = respostaQuizService;
    }

    @PostMapping
    public ResponseEntity<Void> QuizResposta(@RequestBody @Valid CriarRespostaPerguntaDTO dto) {
        respostaQuizService.responderPergunta(dto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
