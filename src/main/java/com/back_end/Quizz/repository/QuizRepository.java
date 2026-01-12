package com.back_end.Quizz.repository;

import com.back_end.Quizz.projection.PerguntaQuiz;
import com.back_end.Quizz.entities.Quiz;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @EntityGraph(attributePaths = {
            "perguntas",
            "perguntas.opcoes"
    })
    Optional<Quiz> findById(long id);

    @Query( value =
        """
            SELECT
                p.ordem AS id,
                p.enunciado,
                q.categoria,
            	p.tempo_limite_segundos,
                MAX(CASE WHEN o.ordem = 1 THEN o.descricao END) AS A,
                MAX(CASE WHEN o.ordem = 2 THEN o.descricao END) AS B,
                MAX(CASE WHEN o.ordem = 3 THEN o.descricao END) AS C,
                MAX(CASE WHEN o.ordem = 4 THEN o.descricao END) AS D,
            
                MAX(
                    CASE\s
                        WHEN o.correta = 1 AND o.ordem = 1 THEN 'A'
                        WHEN o.correta = 1 AND o.ordem = 2 THEN 'B'
                        WHEN o.correta = 1 AND o.ordem = 3 THEN 'C'
                        WHEN o.correta = 1 AND o.ordem = 4 THEN 'D'
                    END
                ) AS correta
            
            FROM pergunta p
            JOIN opcao_resposta o ON o.pergunta_id = p.id
            JOIN quiz q ON q.id = p.quiz_id
            
            WHERE
                q.data_inicio <= NOW()
                AND (q.data_fim IS NULL OR q.data_fim >= NOW())
            
            GROUP BY
                p.id,
                p.enunciado;
        """,
        nativeQuery = true
    )
    List<PerguntaQuiz> QuizDisponivel();
}
