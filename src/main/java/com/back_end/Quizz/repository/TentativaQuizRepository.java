package com.back_end.Quizz.repository;

import com.back_end.Quizz.entities.Quiz;
import com.back_end.Quizz.entities.TentativaQuiz;
import com.back_end.Quizz.entities.Usuario;
import com.back_end.Quizz.entities.enums.StatusQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  TentativaQuizRepository extends JpaRepository<TentativaQuiz, Long> {

    boolean existsByQuizAndUsuario(Quiz quiz, Usuario usuario);

    Optional<TentativaQuiz> findByQuizAndUsuarioAndStatus(
        Quiz quiz,
        Usuario usuario,
        StatusQuiz status
    );

    List<TentativaQuiz> findByUsuarioAndStatus(Usuario usuario, StatusQuiz status);
}
