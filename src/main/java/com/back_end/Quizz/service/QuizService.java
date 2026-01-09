package com.back_end.Quizz.service;

import com.back_end.Quizz.dto.CriarOpcaoRespostaDTO;
import com.back_end.Quizz.dto.CriarPerguntaDTO;
import com.back_end.Quizz.dto.CriarQuizDTO;
import com.back_end.Quizz.entities.OpcaoResposta;
import com.back_end.Quizz.entities.Pergunta;
import com.back_end.Quizz.entities.Quiz;
import com.back_end.Quizz.repository.OpcaoRespostaRepository;
import com.back_end.Quizz.repository.PerguntaRepository;
import com.back_end.Quizz.repository.QuizRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuizService {

    private final QuizRepository quizRepository;
    private final PerguntaRepository perguntaRepository;
    private final OpcaoRespostaRepository opcaoRespostaRepository;

    public QuizService(
            QuizRepository quizRepository,
            PerguntaRepository perguntaRepository,
            OpcaoRespostaRepository opcaoRespostaRepository
    ) {
        this.quizRepository = quizRepository;
        this.perguntaRepository = perguntaRepository;
        this.opcaoRespostaRepository = opcaoRespostaRepository;
    }

    public void criarQuizCompleto(CriarQuizDTO dto) {

        // 1️⃣ Criar Quiz
        Quiz quiz = new Quiz();
        quiz.setTitulo(dto.getTitulo());
        quiz.setDescricao(dto.getDescricao());
        quiz.setCategoria(dto.getCategoria());
        quiz.setDataInicio(dto.getDataInicio());
        quiz.setDataFim(dto.getDataFim());
        quiz.setMinimoAcertos(dto.getMinimoAcertos());
        quiz.setValorCredito(dto.getValorCredito());
        quiz.setPermitirRejogo(dto.isPermitirRejogo());

        quizRepository.save(quiz);

        // 2️⃣ Criar Perguntas
        for (CriarPerguntaDTO perguntaDTO : dto.getPerguntas()) {

            Pergunta pergunta = new Pergunta();
            pergunta.setQuiz(quiz);
            pergunta.setEnunciado(perguntaDTO.getEnunciado());
            pergunta.setTempoLimiteSegundos(perguntaDTO.getTempoLimiteSegundos());
            pergunta.setOrdem(perguntaDTO.getOrdem());

            perguntaRepository.save(pergunta);

            // 3️⃣ Criar Opções
            for (CriarOpcaoRespostaDTO opcaoDTO : perguntaDTO.getOpcoes()) {

                OpcaoResposta opcao = new OpcaoResposta();
                opcao.setPergunta(pergunta);
                opcao.setDescricao(opcaoDTO.getDescricao());
                opcao.setCorreta(opcaoDTO.getCorreta());
                opcao.setOrdem(opcaoDTO.getOrdem());

                opcaoRespostaRepository.save(opcao);
            }
        }
    }
}
