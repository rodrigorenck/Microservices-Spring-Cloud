package br.com.alura.microservicos.loja.form;

import java.util.List;

public class CompraForm {

    private List<ItensForm> itens;

    //endereco de destino - disponibilizado pelo cliente
    // precisamos nos comunicar com o fornecedor para saber o endereco de origem da mercadoria
    private EnderecoForm endereco;

    public List<ItensForm> getItens() {
        return itens;
    }

    public void setItens(List<ItensForm> itens) {
        this.itens = itens;
    }

    public EnderecoForm getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoForm endereco) {
        this.endereco = endereco;
    }
}
