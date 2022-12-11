package com.tcc.saboresmoduloprodutos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tcc.saboresmoduloprodutos.pojo.ImagemProduto;
import com.tcc.saboresmoduloprodutos.repositories.ImagemProdutoRepository;
import com.tcc.saboresmoduloprodutos.service.exceptions.DataIntegrityException;
import com.tcc.saboresmoduloprodutos.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class ImagemProdutoService {
	@Autowired
	private ImagemProdutoRepository imagemProdutoRepository;
	
	public ImagemProduto obterPeloId(Integer id) {
		Optional<ImagemProduto> imagemProduto = imagemProdutoRepository.findById(id);
		return imagemProduto.orElseThrow(() -> new ObjetoNaoEncontradoException("Imagem Não Encontrado para este ID"));
	}
	
	public List<ImagemProduto> listarTodos() {
		List<ImagemProduto> imagemProdutos = imagemProdutoRepository.findAll();
		return imagemProdutos;
	}
	
	public ImagemProduto insert(ImagemProduto imagemProduto) {
		if (imagemProduto.getId() == null) {
			return imagemProdutoRepository.save(imagemProduto);
		}
		return null;
	}
	
	public ImagemProduto update(ImagemProduto imagemProduto) {
		obterPeloId(imagemProduto.getId());
		return imagemProdutoRepository.save(imagemProduto);
	}
	
	public void delete(Integer id) {
		obterPeloId(id);
		try {
			imagemProdutoRepository.deleteById(id);
		} catch (DataIntegrityViolationException dive) {
			throw new DataIntegrityException("Não é possivel excluir o recurso, verifique dependências.");
		}
	}
	
	public ImagemProduto obterPorProduto(Integer id) {
		return imagemProdutoRepository.obterImagemPrincipalPorProduto(id);
	}
	
	public List<ImagemProduto> listarPorProduto(Integer id) {
		return imagemProdutoRepository.obterImagensProduto(id);
	}
	
	public ImagemProduto alterarImagemPrincipal(Integer id) {
		return imagemProdutoRepository.alterarImagemPrincipal(id);
	}
}
