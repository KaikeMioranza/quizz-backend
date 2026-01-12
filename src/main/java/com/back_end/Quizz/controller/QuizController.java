package com.back_end.Quizz.controller;

import com.back_end.Quizz.dto.CriarQuizDTO;
import com.back_end.Quizz.projection.PerguntaQuiz;
import com.back_end.Quizz.service.QuizService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public ResponseEntity<Void> criarQuiz(
            @RequestBody @Valid CriarQuizDTO dto
    ) {
        quizService.criarQuizCompleto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<PerguntaQuiz> buscar() {
        return quizService.obterQuiz();
    }

}
