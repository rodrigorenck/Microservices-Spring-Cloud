package br.com.alura.microservicos.loja.form;

public class EnderecoForm {

    private String rua;
    private int numero;
    private String estado;

    @Override
    public String toString() {
        return "EnderecoForm{" +
                "rua='" + rua + '\'' +
                ", numero=" + numero +
                ", estado='" + estado + '\'' +
                '}';
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
