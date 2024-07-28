package com.projetodio.padroes_projeto_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PadroesProjetoSpringApplication {

	public static void main(String[] args) {
		System.out.println("PGHOST: " + System.getenv("PGHOST"));
		System.out.println("PGPORT: " + System.getenv("PGPORT"));
		System.out.println("PGDATABASE: " + System.getenv("PGDATABASE"));
		System.out.println("PGUSER: " + System.getenv("PGUSER"));
		System.out.println("PGPASSWORD: " + System.getenv("PGPASSWORD"));
		SpringApplication.run(PadroesProjetoSpringApplication.class, args);
		SpringApplication.run(PadroesProjetoSpringApplication.class, args);
	}

}
