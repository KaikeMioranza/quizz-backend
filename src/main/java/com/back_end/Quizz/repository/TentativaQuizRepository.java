package com.back_end.Quizz.repository;

import com.back_end.Quizz.entities.TentativaQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TentativaQuizRepository extends JpaRepository<TentativaQuiz, Long> {
}
