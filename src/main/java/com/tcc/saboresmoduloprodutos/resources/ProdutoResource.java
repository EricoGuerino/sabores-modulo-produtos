package com.tcc.saboresmoduloprodutos.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public String mostrar() {
		return "Teste Produtos!";
	}
	
}
