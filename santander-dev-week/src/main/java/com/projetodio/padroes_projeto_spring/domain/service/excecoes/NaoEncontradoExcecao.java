package com.projetodio.padroes_projeto_spring.domain.service.excecoes;

public class NaoEncontradoExcecao extends ExcecaoNegocios {

    private static final long serialVersionUID = 1L;

    public NaoEncontradoExcecao() {
        super("Resource not found.");
    }

}
