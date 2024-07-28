package com.projetodio.padroes_projeto_spring.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class MetodosComuns {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String icone;

    private String descricao;
}
