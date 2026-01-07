package com.back_end.Quizz.repository;

import com.back_end.Quizz.entities.MensagemMotivacional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemMotivacionalRepository extends JpaRepository<MensagemMotivacional, Long> {
}
