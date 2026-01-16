package com.back_end.Quizz.service;

import com.back_end.Quizz.dto.CriarAvisoImportanteDTO;
import com.back_end.Quizz.entities.AvisoImportante;
import com.back_end.Quizz.repository.AvisoImportanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.*;
import java.util.Date;
import java.util.List;

@Service
public class AvisoImportanteService {

    @Autowired
    AvisoImportanteRepository avisoImportanteRepository;


    public AvisoImportante CriarAvisoImportante(CriarAvisoImportanteDTO dto) {


        Timestamp dataInicio = dto.getDataInicio();

        System.out.println("AGORA BR: " +
                LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));

        Timestamp agora = Timestamp.valueOf(LocalDateTime.now());

        boolean ativo = !agora.toLocalDateTime().isBefore(dataInicio.toLocalDateTime());

        AvisoImportante avImp = new AvisoImportante();

        avImp.setTitulo(dto.getTitulo());
        avImp.setMensagem(dto.getMensagem());
        avImp.setDataInicio(dto.getDataInicio());
        avImp.setDataFim(dto.getDataFim());
        avImp.setAtivo(ativo);
        avImp.setSeveridade(dto.getSeveridade());
        avImp.setDataCriacao(agora);

        return avisoImportanteRepository.save(avImp);
    }

    public List<AvisoImportante> BuscarAvisos() {
        List<AvisoImportante> avisoImportantes = avisoImportanteRepository.findByAtivo(true);

        return avisoImportantes;
    }
}
