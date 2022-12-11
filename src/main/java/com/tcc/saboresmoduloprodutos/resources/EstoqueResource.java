package com.tcc.saboresmoduloprodutos.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tcc.saboresmoduloprodutos.pojo.Estoque;
import com.tcc.saboresmoduloprodutos.service.EstoqueService;
import com.tcc.saboresmoduloprodutos.utils.Util;

@RestController
@RequestMapping("/estoque/controle")
public class EstoqueResource {
	@Autowired
	private EstoqueService estoqueService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listarEstoque() {
		List<Estoque> estoques = estoqueService.listarTodos();
		return Util.buildResponse(HttpStatus.OK).body(estoques);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> obterPorId(@PathVariable("id")Integer id) throws Exception {
		Estoque estoque = estoqueService.obterPeloId(id);
		return Util.buildResponse(HttpStatus.OK).body(estoque);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody Estoque estoque) {
		estoque = estoqueService.insert(estoque);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(estoque.getId()).toUri();
		return Util.buildResponse(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Estoque estoque, @PathVariable("id")Integer id) {
		estoque.setId(id);
		estoque = estoqueService.update(estoque);
		return Util.buildResponse(HttpStatus.NO_CONTENT).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id")Integer id) {
		estoqueService.delete(id);
		return Util.buildResponse(HttpStatus.NO_CONTENT).build();
	}
}
