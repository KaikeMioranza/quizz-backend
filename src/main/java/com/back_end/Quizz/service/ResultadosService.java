package com.back_end.Quizz.service;


import com.back_end.Quizz.entities.TentativaQuiz;
import com.back_end.Quizz.projection.EstatisticasQuizProjection;
import com.back_end.Quizz.repository.TentativaQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResultadosService {

    @Autowired
    private TentativaQuizRepository tentativaQuizRepository;

    public EstatisticasQuizProjection buscarResultados(Long idUsuario) {
        return tentativaQuizRepository.buscarEstatisticas(idUsuario);
    }
}
