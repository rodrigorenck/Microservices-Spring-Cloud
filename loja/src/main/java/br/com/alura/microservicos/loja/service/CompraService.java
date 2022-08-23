package br.com.alura.microservicos.loja.service;

import br.com.alura.microservicos.loja.client.FornecedorClient;
import br.com.alura.microservicos.loja.dto.InfoFornecedorDto;
import br.com.alura.microservicos.loja.dto.InfoPedidoDto;
import br.com.alura.microservicos.loja.form.CompraForm;
import br.com.alura.microservicos.loja.model.Compra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class CompraService {

    private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

    private final FornecedorClient fornecedorClient;

    public CompraService(FornecedorClient fornecedorClient) {
        this.fornecedorClient = fornecedorClient;
    }

    /**
     * Metodo para processar a compra
     * 1 - Vamos pegar o endereco do Fornecedor com base no estado que o cliente nos passou na hora da compra
     * 2 - Precisamos fazer a comunicacao entre o microservico da loja com o do fornecedor
     * 3 - A loja vai fazer uma requisicao do tipo GET para o fornecedor para descobir qual o endereco do  fornecedor desse determinado estado
     * 4 - Enviaremos uma requisicao do tipo POST para o fornecedor para realizar o pedido dos itens que o cliente escolheu
     * 5 - Devolveremos uma Compra - para o cliente conseguir ver as informacoes relevantes depois de realizar um pedido
     */
    public Compra realizaCompra(CompraForm form) {
        final String estado = form.getEndereco().getEstado();

        LOG.info("buscando informacoes do fornecedor de {}", estado);
        InfoFornecedorDto info = fornecedorClient.getInfoPorEstado(estado);
        System.out.println(info.getEndereco());

        LOG.info("realizando pedido");
        //Pedido possui o id e tempo de preparo
        InfoPedidoDto pedido = fornecedorClient.realizaPedido(form.getItens());

        Compra compra = new Compra();
        compra.setPedidoId(pedido.getId());
        compra.setTempoPreparo(pedido.getTempoDePreparo());
        compra.setEnderecoDestino(form.getEndereco());
        return compra;
    }
}
