package com.tcc.saboresmoduloprodutos.facade;

import com.tcc.saboresmoduloprodutos.pojo.Produto;

public class ProdutoFacade {
	
	public static Produto obterProduto(Integer id) throws Exception {
		Produto produto1 = new Produto();
		produto1.setId(1);
		produto1.setNome("Bananinha do Formoso");
		produto1.setDescricao("Delicio");
		Produto produto2 = new Produto();
		produto2.setId(2);
		produto2.setNome("Docinho da Fazenda");
		produto2.setDescricao("Delicio++");
		Produto produto3 = new Produto();
		produto3.setId(3);
		produto3.setNome("Barrinha show");
		produto3.setDescricao("Delicio+++");
		
		if (id == 1) {
			return produto1;
		} else if (id == 2) {
			return produto2;
		} else if (id == 3) {
			return produto3;
		} else {
			throw new RuntimeException("Produto não encontrado");
		}
		
	}
	
}
