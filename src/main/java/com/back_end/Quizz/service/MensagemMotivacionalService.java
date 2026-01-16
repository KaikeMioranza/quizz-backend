package com.back_end.Quizz.service;

import com.back_end.Quizz.dto.CriarMensagemDTO;
import com.back_end.Quizz.entities.AvisoImportante;
import com.back_end.Quizz.entities.MensagemMotivacional;
import com.back_end.Quizz.repository.MensagemMotivacionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

import java.util.List;
import java.util.Optional;

@Service
public class MensagemMotivacionalService {

    @Autowired
    private MensagemMotivacionalRepository mensagemMotivacionalRepository;


    public MensagemMotivacional CriarMensagemMotivacional(CriarMensagemDTO dto) {

        Timestamp agora = Timestamp.from(Instant.now());

        Timestamp dataInicio = dto.getDataInicio();

            // Comparação direta entre dois objetos Timestamp
        boolean podeIniciar = !agora.before(dataInicio);

        MensagemMotivacional mm = new MensagemMotivacional();

        mm.setTitulo(dto.getTitulo());
        mm.setMensagem(dto.getMensagem());
        mm.setAtivo(podeIniciar);
        mm.setDataInicio(dto.getDataInicio());
        mm.setDataFim(dto.getDataFim());
        mm.setDataCriacao(agora);

       return mensagemMotivacionalRepository.save(mm);

    }

    public Optional<MensagemMotivacional> BuscarMensagem() {

        Timestamp hoje = Timestamp.from(Instant.now());

        return mensagemMotivacionalRepository.buscarMensagensValidas(hoje);
    }



}
