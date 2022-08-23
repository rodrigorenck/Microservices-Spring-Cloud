package br.com.alura.microservicos.loja.model;

import br.com.alura.microservicos.loja.form.EnderecoForm;

public class Compra {

    private Long pedidoId;
    private Integer tempoPreparo;
    private EnderecoForm enderecoDestino;

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Integer getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(Integer tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public EnderecoForm getEnderecoDestino() {
        return enderecoDestino;
    }

    public void setEnderecoDestino(EnderecoForm enderecoDestino) {
        this.enderecoDestino = enderecoDestino;
    }
}
