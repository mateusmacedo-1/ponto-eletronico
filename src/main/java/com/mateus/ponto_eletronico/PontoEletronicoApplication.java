package com.mateus.ponto_eletronico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
/*
	@EnableAutoConfiguration
	@Configuration
	@ComponentScan
*/
public class PontoEletronicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PontoEletronicoApplication.class, args);
	}

}
