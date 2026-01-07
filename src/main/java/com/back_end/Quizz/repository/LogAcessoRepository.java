package com.back_end.Quizz.repository;

import com.back_end.Quizz.entities.LogAcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogAcessoRepository extends JpaRepository<LogAcesso, Long> {
}
