package com.back_end.Quizz.service;

import com.back_end.Quizz.entities.Quiz;
import com.back_end.Quizz.entities.TentativaQuiz;
import com.back_end.Quizz.entities.Usuario;
import com.back_end.Quizz.entities.enums.StatusQuiz;
import com.back_end.Quizz.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@Transactional
public class TentativaQuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private TentativaQuizRepository tentativaQuizRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PerguntaRepository perguntaRepository;
    @Autowired
    private RespostaPerguntaRepository respostaPerguntaRepository;

    public TentativaQuiz iniciarTentativaQuiz(Long quizId, Long usuarioId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz não encontrado"));

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("usuario não encontrado"));

        boolean jaRespondeu = tentativaQuizRepository
                .existsByQuizAndUsuario(quiz, usuario);
        if (jaRespondeu) {
            throw new RuntimeException("Quiz já respondido");
        }
        TentativaQuiz tentativa = new TentativaQuiz();
        tentativa.setQuiz(quiz);
        tentativa.setUsuario(usuario);
        tentativa.setDataInicio(Timestamp.valueOf(LocalDateTime.now()));
        tentativa.setStatus(StatusQuiz.EM_ANDAMENTO);
        return tentativaQuizRepository.save(tentativa);
    }

    public TentativaQuiz finalizarTentativaQuiz(Long tentativaQuizId){
        TentativaQuiz tentativa = tentativaQuizRepository.findById(tentativaQuizId)
                .orElseThrow(() -> new RuntimeException("Tentativa de quiz não encontrada"));

        /* Evita finalizar duas vezes */
        if (tentativa.getStatus() == StatusQuiz.FINALIZADO) {
            return tentativa;
        }

        Long quizId = tentativa.getQuiz().getId();


        long totalPerguntas = perguntaRepository.countPerguntasByQuizId(quizId);
        long totalRespondidas = respostaPerguntaRepository.countByTentativaQuizId(tentativaQuizId);

        long totalAcertos = respostaPerguntaRepository
                .countByTentativaQuizIdAndCorretaTrue(tentativaQuizId);

        long totalErros = respostaPerguntaRepository
                .countByTentativaQuizIdAndCorretaFalse(tentativaQuizId);

        long totalPulos = totalPerguntas - totalRespondidas;
        if (totalPulos < 0) totalPulos = 0;

        /* Regra de aprovação 70% */
        double percentualAcerto = (totalPerguntas == 0)
                ? 0
                : (double) totalAcertos / totalPerguntas;

        boolean aprovado = percentualAcerto >= 0.7;


        tentativa.setDataFim(Timestamp.valueOf(LocalDateTime.now()));
        tentativa.setStatus(StatusQuiz.FINALIZADO);
        tentativa.setTotalAcertos((int) totalAcertos);
        tentativa.setTotalErros((int) totalErros);
        tentativa.setTotalPulos((int) totalPulos);
        tentativa.setAprovado(aprovado);
        tentativa.setCreditoGerado(false); // regra posterior pode alterar

        return tentativaQuizRepository.save(tentativa);
    }
}
