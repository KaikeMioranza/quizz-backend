package com.back_end.Quizz.controller;

import com.back_end.Quizz.dto.BuscarTentativaQuizDTO;
import com.back_end.Quizz.dto.CriarTentativaQuizDTO;
import com.back_end.Quizz.dto.FinalizarTentativaQuizDTO;
import com.back_end.Quizz.entities.TentativaQuiz;
import com.back_end.Quizz.service.TentativaQuizService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<TentativaQuiz>> buscarTentativasQuiz(
            @RequestParam Long usuarioId) {

        List<TentativaQuiz> tentativas =
                tentativaQuizService.buscarTentativasQuiz(usuarioId);

        return ResponseEntity.ok(tentativas);
    }

}
