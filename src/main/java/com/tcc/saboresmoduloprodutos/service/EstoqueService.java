package com.tcc.saboresmoduloprodutos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tcc.saboresmoduloprodutos.pojo.Estoque;
import com.tcc.saboresmoduloprodutos.repositories.EstoqueRepository;
import com.tcc.saboresmoduloprodutos.service.exceptions.DataIntegrityException;
import com.tcc.saboresmoduloprodutos.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class EstoqueService {
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	public Estoque obterPeloId(Integer id) {
		Optional<Estoque> estoque = estoqueRepository.findById(id);
		return estoque.orElseThrow(() -> new ObjetoNaoEncontradoException("Estoque Não Encontrado para este ID"));
	}
	
	public List<Estoque> listarTodos() {
		List<Estoque> estoques = estoqueRepository.findAll();
		return estoques;
	}
	
	public Estoque insert(Estoque estoque) {
		if (estoque.getId() == null) {
			return estoqueRepository.save(estoque);
		}
		return null;
	}
	
	public Estoque update(Estoque estoque) {
		obterPeloId(estoque.getId());
		return estoqueRepository.save(estoque);
	}
	
	public void delete(Integer id) {
		obterPeloId(id);
		try {
			estoqueRepository.deleteById(id);
		} catch (DataIntegrityViolationException dive) {
			throw new DataIntegrityException("Não é possivel excluir o recurso, verifique dependências.");
		}
	}
	
	public Boolean verificaSeTemProdutoEmEstoque(Integer idProduto) {
		return estoqueRepository.verificaSePossuiProdutoEmEstoque(idProduto);
	}
}
