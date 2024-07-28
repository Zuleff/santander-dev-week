package com.projetodio.padroes_projeto_spring.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String numero;

    private String agencia;

    @Column(scale = 13, precision = 2)
    private BigDecimal  balanca;

    @Column(scale = 13, precision = 2)
    private BigDecimal  limite;

}
