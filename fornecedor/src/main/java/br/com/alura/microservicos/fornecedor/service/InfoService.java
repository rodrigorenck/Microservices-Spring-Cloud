package br.com.alura.microservicos.fornecedor.service;

import br.com.alura.microservicos.fornecedor.model.InfoFornecedor;
import br.com.alura.microservicos.fornecedor.repository.InfoFornecedorRepository;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    private final InfoFornecedorRepository fornecedorRepository;


    public InfoService(InfoFornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }


    public InfoFornecedor getInfoPorEstado(String estado) {
        return fornecedorRepository.getInfoFornecedorByEstado(estado);
    }
}
