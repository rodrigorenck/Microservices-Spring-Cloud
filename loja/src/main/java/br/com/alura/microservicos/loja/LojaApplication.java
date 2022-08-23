package br.com.alura.microservicos.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class LojaApplication {
	/**
	 * Spring vai criar uma instancia de RestTemplate com a inteligencia necessaria para traduzir aquele "fornecedor" da url pelo endereco - que ele vai pegar no eureka
	 * Agora eh o Spring quem vai gerenciar o meu RestTemplate (client)
	 */
//	@Bean
//	@LoadBalanced
//	public RestTemplate getRestTemplate(){
//		return new RestTemplate();
//	}

	public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);
	}

}
