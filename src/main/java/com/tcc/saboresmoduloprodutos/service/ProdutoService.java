package com.tcc.saboresmoduloprodutos.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tcc.saboresmoduloprodutos.pojo.Estoque;
import com.tcc.saboresmoduloprodutos.pojo.Produto;
import com.tcc.saboresmoduloprodutos.repositories.ProdutoRepository;
import com.tcc.saboresmoduloprodutos.service.exceptions.DataIntegrityException;
import com.tcc.saboresmoduloprodutos.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstoqueService estoqueService;
	
	
	public Produto obterPeloId(Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.orElseThrow(() -> new ObjetoNaoEncontradoException("Produto Não Encontrado para este ID"));
	}
	
	public List<Produto> listarTodos() {
		List<Produto> produtos = produtoRepository.findAll();
		return produtos;
	}
	
	public Produto insert(Produto produto) {
		if (produto.getId() == null) {
			produto = produtoRepository.save(produto);
			Estoque estoque = new Estoque(produto);
			estoqueService.insert(estoque);
			
			return produto;
		}
		
		return null;
	}
	
	public Produto update(Produto produto) {
		obterPeloId(produto.getId());
		return produtoRepository.save(produto);
	}
	
	public void delete(Integer id) {
		obterPeloId(id);
		try {
			produtoRepository.deleteById(id);
			Estoque estoque = estoqueService.obterPeloId(id);
			estoqueService.delete(estoque.getId());
			
		} catch (DataIntegrityViolationException dive) {
			throw new DataIntegrityException("Não é possivel excluir o recurso, verifique dependências.");
		}
	}
	
	public void deletarFabricanteProduto(Integer idFabricante) {
		List<Produto> produtos = produtoRepository.listarProdutosPorFabricante(idFabricante);
		for (Produto produto : produtos) {
			produto.setFabricante(null);
		}
		produtoRepository.alteraProdutosLote(produtos);
	}
	
	public void deletarCategoriaProduto(Integer idCategoria) {
		List<Produto> produtos = produtoRepository.listarProdutosPorCategoria(idCategoria);
		for (Produto produto : produtos) {
			produto.getCategorias().remove(idCategoria);
		}
		produtoRepository.alteraProdutosLote(produtos);
	}
	
	public List<Produto> filtrarProdutos(
			String nome, List<Integer> fabricantes, List<Integer> categorias, 
			Integer precoMinimo, Integer precoMaximo, Integer pesoMinimo, Integer pesoMaximo) {
		return produtoRepository.filtrarProdutos(nome, fabricantes, categorias, precoMinimo, precoMaximo, pesoMinimo, pesoMaximo);
	}
	
	public Map<String,Object> carregarValoresMinMax() {
		
		Double maxPeso = produtoRepository.carregarMaiorPeso();
		Double minPeso = produtoRepository.carregarMenorPeso();
		Double maxPreco = produtoRepository.carregarMaiorPreco();
		Double minPreco = produtoRepository.carregarMenorPreco();
		
		Map<String,Object> retornoWS = new HashMap<String,Object>();
		retornoWS.put("minPeso", Integer.valueOf((int)Math.floor(minPeso)));
		retornoWS.put("maxPeso", Integer.valueOf((int)Math.ceil(maxPeso)));
		retornoWS.put("maxPreco", Integer.valueOf((int)Math.ceil(maxPreco)));
		retornoWS.put("minPreco", Integer.valueOf((int)Math.floor(minPreco)));
		
		return retornoWS;
	}
}
