package com.tcc.saboresmoduloprodutos.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tcc.saboresmoduloprodutos.pojo.Produto;
import com.tcc.saboresmoduloprodutos.service.ProdutoService;
import com.tcc.saboresmoduloprodutos.utils.Util;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listarProdutos() {
		List<Produto> produtos = produtoService.listarTodos();
		return Util.buildResponse(HttpStatus.OK).body(produtos);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> obterPorId(@PathVariable("id")Integer id) throws Exception {
		Produto produto = produtoService.obterPeloId(id);
		return Util.buildResponse(HttpStatus.OK).body(produto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody Produto produto) {
		produto = produtoService.insert(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId()).toUri();
		return Util.buildResponse(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Produto produto, @PathVariable("id")Integer id) {
		produto.setId(id);
		produto = produtoService.update(produto);
		return Util.buildResponse(HttpStatus.NO_CONTENT).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id")Integer id) {
		produtoService.delete(id);
		return Util.buildResponse(HttpStatus.NO_CONTENT).build();
	}
	
	@RequestMapping(value = "/delete/fabricantes/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCascadeFabricantes(@PathVariable("id")Integer id) {
		List<Produto> produtos = produtoService.listarTodos();
		//(id);
		return Util.buildResponse(HttpStatus.NO_CONTENT).build();
	}
}
