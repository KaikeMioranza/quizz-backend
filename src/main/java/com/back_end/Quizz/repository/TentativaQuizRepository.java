package com.back_end.Quizz.repository;

import com.back_end.Quizz.entities.Quiz;
import com.back_end.Quizz.entities.TentativaQuiz;
import com.back_end.Quizz.entities.Usuario;
import com.back_end.Quizz.entities.enums.StatusQuiz;
import com.back_end.Quizz.projection.EstatisticasQuizProjection;
import feign.Param;
import org.hibernate.sql.ast.tree.expression.QueryLiteral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  TentativaQuizRepository extends JpaRepository<TentativaQuiz, Long> {

    boolean existsByQuizAndUsuario(Quiz quiz, Usuario usuario);

    Optional<TentativaQuiz> findByQuizAndUsuarioAndStatus(
        Quiz quiz,
        Usuario usuario,
        StatusQuiz status
    );

    List<TentativaQuiz> findByUsuarioAndStatus(Usuario usuario, StatusQuiz status);

    @Query(value = """
        select
        	count(quiz_id * 1) as quizRespondidos,
            sum(total_acertos) as totalAcertos,
            sum(total_erros) as totalErros,
            sum(total_pulos) as totalPulos
        from
        	tentativa_quiz
        where
        	usuario_id = :idUsuario 
    """, nativeQuery = true)
    EstatisticasQuizProjection buscarEstatisticas(@Param("idUsuario") Long idUsuario);
}
