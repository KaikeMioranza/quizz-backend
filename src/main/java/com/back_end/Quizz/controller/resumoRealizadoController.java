package com.back_end.Quizz.controller;

import com.back_end.Quizz.entities.TentativaQuiz;
import com.back_end.Quizz.projection.EstatisticasQuizProjection;
import com.back_end.Quizz.service.ResultadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/estatisticas")
public class resumoRealizadoController {

    @Autowired
    ResultadosService resultadosService;

    @GetMapping("/{idUsuario}")
    public ResponseEntity<EstatisticasQuizProjection> buscar(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(resultadosService.buscarResultados(idUsuario));
    }

}
