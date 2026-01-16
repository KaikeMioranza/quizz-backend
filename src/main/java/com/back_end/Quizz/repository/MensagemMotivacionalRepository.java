package com.back_end.Quizz.repository;

import com.back_end.Quizz.entities.AvisoImportante;
import com.back_end.Quizz.entities.MensagemMotivacional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MensagemMotivacionalRepository extends JpaRepository<MensagemMotivacional, Long> {

    @Query("""
    SELECT m FROM MensagemMotivacional m
    WHERE m.ativo = true
    AND :hoje BETWEEN m.dataInicio AND m.dataFim
    ORDER BY m.dataInicio DESC
    """)
    Optional<MensagemMotivacional> buscarMensagensValidas(@Param("hoje") Timestamp hoje);
}
