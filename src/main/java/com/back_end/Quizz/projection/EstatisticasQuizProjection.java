package com.back_end.Quizz.projection;

public interface EstatisticasQuizProjection {

    Long getQuizRespondidos();
    Long getTotalAcertos();
    Long getTotalErros();
    Long getTotalPulos();
}
