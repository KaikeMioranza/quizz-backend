package com.back_end.Quizz.repository;

import com.back_end.Quizz.entities.AvisoImportante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvisoImportanteRepository extends JpaRepository<AvisoImportante, Long> {

    public List<AvisoImportante> findByAtivo(Boolean ativo);
}
