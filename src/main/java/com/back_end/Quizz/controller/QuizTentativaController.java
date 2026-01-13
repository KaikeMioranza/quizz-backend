package com.back_end.Quizz.controller;

import com.back_end.Quizz.dto.CriarTentativaQuizDTO;
import com.back_end.Quizz.service.TentativaQuizService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/QuizTentativa")
public class QuizTentativaController {
    private final TentativaQuizService tentativaQuizService;

    public QuizTentativaController(TentativaQuizService tentativaQuizService) {
        this.tentativaQuizService = tentativaQuizService;
    }

    @PostMapping
    public ResponseEntity<Void> QuizTentativa(@RequestBody @Valid
        CriarTentativaQuizDTO dto){
        tentativaQuizService.iniciarTentativaQuiz(dto.getQuizId(),dto.getUsuarioId());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
