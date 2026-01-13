package com.back_end.Quizz.repository;

import com.back_end.Quizz.entities.OpcaoResposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OpcaoRespostaRepository extends JpaRepository<OpcaoResposta, Long> {

    @Query("SELECT o.correta FROM OpcaoResposta o WHERE o.id = :id")
    Optional<Boolean> findCorretaById(Long id);

}
