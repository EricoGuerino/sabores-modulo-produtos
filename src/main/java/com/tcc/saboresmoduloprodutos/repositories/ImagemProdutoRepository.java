package com.tcc.saboresmoduloprodutos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tcc.saboresmoduloprodutos.pojo.ImagemProduto;

@Repository
public interface ImagemProdutoRepository extends JpaRepository<ImagemProduto, Integer> {
	
	@Query("SELECT ip FROM ImagemProduto ip WHERE ip.produto.id = ?1 and ip.isImagemPrincipal = true")
	ImagemProduto obterImagemPrincipalPorProduto(Integer id);
	
	@Query("SELECT ip FROM ImagemProduto ip WHERE ip.produto.id = ?1")
	List<ImagemProduto> obterImagensProduto(Integer id);
	
	abstract ImagemProduto alterarImagemPrincipal(Integer id);
}
