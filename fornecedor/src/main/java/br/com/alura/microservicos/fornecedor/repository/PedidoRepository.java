package br.com.alura.microservicos.fornecedor.repository;

import br.com.alura.microservicos.fornecedor.model.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
