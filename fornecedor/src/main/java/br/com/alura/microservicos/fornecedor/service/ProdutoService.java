package br.com.alura.microservicos.fornecedor.service;

import java.util.List;
import java.util.Locale;

import br.com.alura.microservicos.fornecedor.model.Produto;
import br.com.alura.microservicos.fornecedor.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> getProdutosPorEstado(String estado) {
		estado = estado.toUpperCase();
		return produtoRepository.findByEstado(estado);
	}

	
}
