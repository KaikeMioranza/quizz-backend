package com.back_end.Quizz.repository;

import com.back_end.Quizz.entities.TransacaoCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoCreditoRepository extends JpaRepository<TransacaoCredito, Long> {
}
