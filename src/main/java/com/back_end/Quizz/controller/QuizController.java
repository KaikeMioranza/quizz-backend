package com.back_end.Quizz.controller;

import com.back_end.Quizz.dto.CriarQuizDTO;
import com.back_end.Quizz.entities.Quiz;
import com.back_end.Quizz.repository.QuizRepository;
import com.back_end.Quizz.service.QuizService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Quiz buscar(@PathVariable Long id) {
        return QuizRepository.findById(id).get();
    }
}
