package br.edu.infnet.appMatheusAvelino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Classe principal que inicializa a aplicação Spring Boot.
 * <p>
 * A anotação {@link SpringBootApplication} configura automaticamente o contexto da aplicação, incluindo a configuração
 * do Spring Boot e a configuração de escaneamento de componentes.
 * </p>
 * <p>
 * A anotação {@link EnableFeignClients} ativa o suporte ao Feign, permitindo que a aplicação use clientes Feign para
 * comunicação com serviços externos via HTTP.
 * </p>
 */
@SpringBootApplication
@EnableFeignClients
public class AppMatheusAvelinoApplication {

    /**
     * Método principal que inicia a aplicação Spring Boot.
     * <p>
     * Este método é o ponto de entrada da aplicação, que usa a classe {@link SpringApplication} para iniciar o contexto
     * da aplicação Spring Boot.
     * </p>
     * 
     * @param args Argumentos da linha de comando fornecidos para a aplicação.
     */
    public static void main(String[] args) {
        SpringApplication.run(AppMatheusAvelinoApplication.class, args);
    }
}
