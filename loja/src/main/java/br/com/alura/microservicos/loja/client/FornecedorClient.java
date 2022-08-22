package br.com.alura.microservicos.loja.client;

import br.com.alura.microservicos.loja.dto.InfoFornecedorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Aqui passamos qual o ID - que esta registrado no Eureka
 * Feign ta conectado com o Client Load Balance que ta conectado com o Eureka que possui as informacoes que precisamo - ip e porta
 */
@FeignClient("fornecedor")
public interface FornecedorClient {

    @GetMapping("info/{estado}")
    InfoFornecedorDto getInfoPorEstado(@PathVariable String estado);
}
