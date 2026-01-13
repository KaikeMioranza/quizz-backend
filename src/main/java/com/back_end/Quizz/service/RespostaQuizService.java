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
    public RespostaQuizService(
            RespostaPerguntaRepository respostaPerguntaRepository,
            TentativaQuizRepository tentativaQuizRepository,
            OpcaoRespostaRepository opcaoRespostaRepository,
            PerguntaRepository perguntaRepository
    ) {
        this.respostaPerguntaRepository = respostaPerguntaRepository;
        this.tentativaQuizRepository = tentativaQuizRepository;
        this.opcaoRespostaRepository = opcaoRespostaRepository;
        this.perguntaRepository = perguntaRepository;
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


        RespostaPergunta respP = new RespostaPergunta();
        respP.setTentativaQuiz(tentativa);
        respP.setPergunta(pergunta);
        respP.setOpcaoResposta(opcaoResposta);
        respP.setCorreta(correta);
        respP.setDataResposta(Timestamp.valueOf(LocalDateTime.now()));
        return respostaPerguntaRepository.save(respP);
    }
}
