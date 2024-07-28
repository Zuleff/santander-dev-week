package com.projetodio.padroes_projeto_spring.domain.service.excecoes;



public class ExcecaoNegocios extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcecaoNegocios(String message) {
        super(message);
    }
}