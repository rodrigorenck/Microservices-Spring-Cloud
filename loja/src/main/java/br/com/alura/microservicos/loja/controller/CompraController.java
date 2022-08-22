package br.com.alura.microservicos.loja.controller;


import br.com.alura.microservicos.loja.form.CompraForm;
import br.com.alura.microservicos.loja.service.CompraService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public void realizarCompra(@RequestBody CompraForm form){
        compraService.realizaCompra(form);
    }

}
