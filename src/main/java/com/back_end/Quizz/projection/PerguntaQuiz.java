package com.back_end.Quizz.projection;

public interface PerguntaQuiz {

    Long getId();
    String getEnunciado();
    String getCategoria();
    Integer getTempoLimiteSegundos();

    String getA();
    String getB();
    String getC();
    String getD();

    String getCorreta();
}
