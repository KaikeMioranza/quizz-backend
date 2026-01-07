package com.back_end.Quizz.repository;

import com.back_end.Quizz.entities.OpcaoResposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcaoRespostaRepository extends JpaRepository<OpcaoResposta, Long> {
}
