package br.com.alura.microservicos.loja.service;

import br.com.alura.microservicos.loja.client.FornecedorClient;
import br.com.alura.microservicos.loja.dto.InfoFornecedorDto;
import br.com.alura.microservicos.loja.form.CompraForm;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    private final FornecedorClient fornecedorClient;

    public CompraService(FornecedorClient fornecedorClient) {
        this.fornecedorClient = fornecedorClient;
    }

    /**
     * Metodo para processar a compra
     * 1 - Vamos pegar o endereco do Fornecedor com base no estado que o cliente nos passou na hora da compra
     * 2 - Precisamos fazer a comunicacao entre o microservico da loja com o do fornecedor
     * 3 - A loja vai fazer uma requisicao do tipo GET para o fornecedor para descobir qual o endereco do  fornecedor desse determinado estado
     */
    public void realizaCompra(CompraForm form) {
        InfoFornecedorDto info = fornecedorClient.getInfoPorEstado(form.getEndereco().getEstado());
        //aqui ja saberiamos o endereco do fornecedor
        System.out.println(info.getEndereco());
    }
}
