package com.back_end.Quizz.repository;

import com.back_end.Quizz.entities.OpcaoResposta;
import com.back_end.Quizz.entities.Pergunta;
import com.back_end.Quizz.entities.RespostaPergunta;
import com.back_end.Quizz.entities.TentativaQuiz;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaPerguntaRepository extends JpaRepository<RespostaPergunta, Long> {



    boolean existsByTentativaQuizAndPergunta(
            TentativaQuiz tentativaQuiz,
            Pergunta pergunta
    );

    long countByTentativaQuizId(Long tentativaQuizId);
    long countByTentativaQuizIdAndCorretaTrue(Long tentativaQuizId);
    long countByTentativaQuizIdAndCorretaFalse(Long tentativaQuizId);

}
