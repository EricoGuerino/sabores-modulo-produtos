package com.tcc.saboresmoduloprodutos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tcc.saboresmoduloprodutos.pojo.Produto;
import com.tcc.saboresmoduloprodutos.repositories.ProdutoRepository;
import com.tcc.saboresmoduloprodutos.service.exceptions.DataIntegrityException;
import com.tcc.saboresmoduloprodutos.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
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
			return produtoRepository.save(produto);
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
		} catch (DataIntegrityViolationException dive) {
			throw new DataIntegrityException("Não é possivel excluir o recurso, verifique dependências.");
		}
	}
}
