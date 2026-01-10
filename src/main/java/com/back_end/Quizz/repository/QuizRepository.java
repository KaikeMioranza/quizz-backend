package com.back_end.Quizz.repository;

import com.back_end.Quizz.entities.Quiz;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @EntityGraph(attributePaths = {
            "perguntas",
            "perguntas.opcoes"
    })
    Optional<Quiz> findById(long id);
}
