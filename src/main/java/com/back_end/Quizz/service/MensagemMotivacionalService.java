package com.back_end.Quizz.service;

import com.back_end.Quizz.dto.CriarMensagemDTO;
import com.back_end.Quizz.entities.AvisoImportante;
import com.back_end.Quizz.entities.MensagemMotivacional;
import com.back_end.Quizz.repository.MensagemMotivacionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class MensagemMotivacionalService {

    @Autowired
    private MensagemMotivacionalRepository mensagemMotivacionalRepository;


    public MensagemMotivacional CriarMensagemMotivacional(CriarMensagemDTO dto) {

        LocalDateTime agora =
                LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));

        LocalDateTime dataInicio = dto.getDataInicio();

        boolean podeIniciar = !agora.isBefore(dataInicio);

        MensagemMotivacional mm = new MensagemMotivacional();

        mm.setMensagem(dto.getMensagem());
        mm.setAtivo(podeIniciar);
        mm.setDataInicio(dto.getDataInicio());
        mm.setDataFim(dto.getDataFim());
        mm.setDataCriacao(agora);

       return mensagemMotivacionalRepository.save(mm);

    }



}
