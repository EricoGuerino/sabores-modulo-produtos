package com.tcc.saboresmoduloprodutos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tcc.saboresmoduloprodutos.pojo.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
	
	@Query("SELECT (COUNT(e.quantidade) > 0) FROM Estoque e WHERE e.produto.id = ?1")
	Boolean verificaSePossuiProdutoEmEstoque(Integer idProduto);
	
	@Query("SELECT e FROM Estoque e WHERE e.produto.id = ?1")
	Estoque buscarEstoquePorProduto(Integer idProduto);
	
}
