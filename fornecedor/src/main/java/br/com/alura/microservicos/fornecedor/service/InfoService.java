package br.com.alura.microservicos.fornecedor.service;

import br.com.alura.microservicos.fornecedor.model.InfoFornecedor;
import br.com.alura.microservicos.fornecedor.repository.InfoFornecedorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    private static final Logger LOG = LoggerFactory.getLogger(InfoService.class);

    private final InfoFornecedorRepository fornecedorRepository;


    public InfoService(InfoFornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }


    public InfoFornecedor getInfoPorEstado(String estado) {
        LOG.info("informacoes buscadas");
        return fornecedorRepository.getInfoFornecedorByEstado(estado);
    }
}
