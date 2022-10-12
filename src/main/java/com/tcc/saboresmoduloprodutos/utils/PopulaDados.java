package com.tcc.saboresmoduloprodutos.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcc.saboresmoduloprodutos.pojo.Produto;
import com.tcc.saboresmoduloprodutos.repositories.ProdutoRepository;

@Component
public class PopulaDados {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PostConstruct
	public void populaDados() {
		Produto produto1 = new Produto(null, "Bananinha do Formoso", "Show", 1, null, 19.99, 600.00);
		Produto produto2 = new Produto(null, "Docinho da Fazenda", "Show+", 1, null, 14.99, 300.00);
		Produto produto3 = new Produto(null, "Barrinha dos Famosos", "Show++", 3, null, 49.99, 800.00);
		
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
	}
	
}
