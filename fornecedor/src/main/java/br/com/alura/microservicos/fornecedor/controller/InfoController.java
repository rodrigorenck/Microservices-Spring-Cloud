package br.com.alura.microservicos.fornecedor.controller;


import br.com.alura.microservicos.fornecedor.model.InfoFornecedor;
import br.com.alura.microservicos.fornecedor.service.InfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

    private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);
    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    //aqui estamos devolvendo uma classe do dominio pois ela nao possui relacionamentos entao um DTO acabaria sendo igual a ela
    @GetMapping("/{estado}")
    public InfoFornecedor getInfoPorEstado(@PathVariable String estado){
        LOG.info("recebido pedido de informacoes do fornecedor de {}", estado);
        return infoService.getInfoPorEstado(estado);
    }
}
