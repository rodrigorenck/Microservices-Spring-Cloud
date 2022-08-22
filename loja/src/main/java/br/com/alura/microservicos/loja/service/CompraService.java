package br.com.alura.microservicos.loja.service;

import br.com.alura.microservicos.loja.dto.InfoFornecedorDto;
import br.com.alura.microservicos.loja.form.CompraForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    //classe do spring que nos permite fazer requisicoes
    //agora o Spring que gerencia ele
    @Autowired
    private RestTemplate client;

    /**
     * Metodo para processar a compra
     * 1 - Vamos pegar o endereco do Fornecedor com base no estado que o cliente nos passou na hora da compra
     * 2 - Precisamos fazer a comunicacao entre o microservico da loja com o do fornecedor
     * 3 - A loja vai fazer uma requisicao do tipo GET para o fornecedor para descobir qual o endereco do  fornecedor desse determinado estado
     */
    public void realizaCompra(CompraForm form) {
        //a porta 8080 eh a que esta a minha loja, portanto tenho que colocar em outra se nao vai dar conflito
        //info/ESTADO que o cliente passou na hora da compra -> dessa forma acessarmos o fornecedor desse estado
        //a nossa Loja vai procurar no Eureka qual o endereco do fornecedor e colocar ali na URL
        ResponseEntity<InfoFornecedorDto> exchange = client.exchange("http://fornecedor/info/" + form.getEndereco().getEstado(),
                HttpMethod.GET, null, InfoFornecedorDto.class);

        //aqui ja saberiamos o endereco do fornecedor
        System.out.println(exchange.getBody().getEndereco());
    }
}
