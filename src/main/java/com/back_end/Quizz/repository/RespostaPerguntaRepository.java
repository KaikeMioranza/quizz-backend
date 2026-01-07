package com.back_end.Quizz.repository;

import com.back_end.Quizz.entities.RespostaPergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaPerguntaRepository extends JpaRepository<RespostaPergunta, Long> {
}
