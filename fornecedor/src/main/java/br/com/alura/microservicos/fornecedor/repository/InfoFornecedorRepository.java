package br.com.alura.microservicos.fornecedor.repository;


import br.com.alura.microservicos.fornecedor.model.InfoFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoFornecedorRepository extends JpaRepository<InfoFornecedor, Long> {

    public InfoFornecedor getInfoFornecedorByEstado(String estado);

}
