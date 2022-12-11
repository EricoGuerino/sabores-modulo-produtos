package com.tcc.saboresmoduloprodutos.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tcc.saboresmoduloprodutos.pojo.ImagemProduto;
import com.tcc.saboresmoduloprodutos.service.ImagemProdutoService;

@Component
public class ImagemProdutoRepositoryImpl {
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ImagemProdutoService imagemProdutoService;
	
	@Transactional
	@Modifying
	public ImagemProduto alterarImagemPrincipal(Integer id) {
		ImagemProduto imagem = imagemProdutoService.obterPeloId(id);
		imagem.setIsImagemPrincipal(Boolean.TRUE);
		imagem = imagemProdutoService.update(imagem);
		
		List<ImagemProduto> imagens = imagemProdutoService.listarPorProduto(imagem.getProduto().getId());
		for (ImagemProduto img : imagens) {
			if (!img.getId().equals(imagem.getId())) {
				img.setIsImagemPrincipal(Boolean.FALSE);
				imagemProdutoService.update(img);
			}
		}
		
		return imagem;
	}
}
