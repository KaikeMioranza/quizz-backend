package com.back_end.Quizz.service;

import com.back_end.Quizz.dto.CriarRespostaPerguntaDTO;
import com.back_end.Quizz.entities.OpcaoResposta;
import com.back_end.Quizz.entities.Pergunta;
import com.back_end.Quizz.entities.RespostaPergunta;
import com.back_end.Quizz.entities.TentativaQuiz;
import com.back_end.Quizz.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@Transactional
public class RespostaQuizService {

    private final RespostaPerguntaRepository respostaPerguntaRepository;
    private final TentativaQuizRepository tentativaQuizRepository;
    private final OpcaoRespostaRepository opcaoRespostaRepository;
    private final PerguntaRepository perguntaRepository;
    private final TentativaQuizService tentativaQuizService;

    public RespostaQuizService(
            RespostaPerguntaRepository respostaPerguntaRepository,
            TentativaQuizRepository tentativaQuizRepository,
            OpcaoRespostaRepository opcaoRespostaRepository,
            PerguntaRepository perguntaRepository,
            TentativaQuizService tentativaQuizService
    ) {
        this.respostaPerguntaRepository = respostaPerguntaRepository;
        this.tentativaQuizRepository = tentativaQuizRepository;
        this.opcaoRespostaRepository = opcaoRespostaRepository;
        this.perguntaRepository = perguntaRepository;
        this.tentativaQuizService = tentativaQuizService;
    }

    public RespostaPergunta responderPergunta(CriarRespostaPerguntaDTO dto) {
        TentativaQuiz tentativa = tentativaQuizRepository.findById(dto.getTentativaQuizId())
                .orElseThrow(() -> new RuntimeException("tentativaQuiz nao encontrada"));
        Pergunta pergunta = perguntaRepository.findById(dto.getPerguntaId())
                .orElseThrow(() -> new RuntimeException("pergunta não encontrada"));
        OpcaoResposta opcaoResposta = opcaoRespostaRepository.findById(dto.getOpcaoRespostaId())
                .orElseThrow(() -> new RuntimeException("opcao resposta não encontrada"));
        boolean correta = opcaoRespostaRepository
                .findCorretaById(dto.getOpcaoRespostaId())
                .orElseThrow(() -> new RuntimeException("Opção não encontrada"));
        if (!opcaoResposta.getPergunta().getId().equals(pergunta.getId())) {
            throw new RuntimeException("Opção não pertence à pergunta");
        }
        // ✅ Verifica se já respondeu
        boolean jaRespondida = respostaPerguntaRepository
                .existsByTentativaQuizAndPergunta(tentativa, pergunta);
        if (jaRespondida) {
            throw new RuntimeException("Pergunta já respondida");
        }


        RespostaPergunta resp = new RespostaPergunta();
        resp.setTentativaQuiz(tentativa);
        resp.setPergunta(pergunta);
        resp.setOpcaoResposta(opcaoResposta);
        resp.setCorreta(correta);
        resp.setDataResposta(Timestamp.valueOf(LocalDateTime.now()));
        respostaPerguntaRepository.save(resp);

        long totalPerguntas = perguntaRepository
                .countPerguntasByQuizId(tentativa.getQuiz().getId());


        long totalRespondidas = respostaPerguntaRepository
                .countByTentativaQuizId(tentativa.getId());


        if (totalRespondidas >= totalPerguntas) {
            tentativaQuizService.finalizarTentativaQuiz(tentativa.getId());
        }


        return resp;

    }
}
