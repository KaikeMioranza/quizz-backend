package com.back_end.Quizz.service;

import com.back_end.Quizz.entities.Quiz;
import com.back_end.Quizz.entities.TentativaQuiz;
import com.back_end.Quizz.entities.Usuario;
import com.back_end.Quizz.entities.enums.StatusQuiz;
import com.back_end.Quizz.repository.QuizRepository;
import com.back_end.Quizz.repository.TentativaQuizRepository;
import com.back_end.Quizz.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@Transactional
public class TentativaQuizService {

    private final QuizRepository quizRepository;
    private final TentativaQuizRepository tentativaQuizRepository;
    private final UsuarioRepository usuarioRepository;

    public TentativaQuizService(
            QuizRepository quizRepository
            , TentativaQuizRepository tentativaQuizRepository
            , UsuarioRepository usuarioRepository) {
        this.quizRepository = quizRepository;
        this.tentativaQuizRepository = tentativaQuizRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public TentativaQuiz iniciarTentativaQuiz(Long quiz_id, Long usuario_id) {
        Quiz quiz = quizRepository.findById(quiz_id)
                .orElseThrow(() -> new RuntimeException("Quiz não encontrado"));

        Usuario usuario = usuarioRepository.findById(usuario_id)
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

}
