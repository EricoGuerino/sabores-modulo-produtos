package com.tcc.saboresmoduloprodutos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tcc.saboresmoduloprodutos.pojo.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	abstract void alteraProdutosLote(List<Produto> produto);
	
	@Query("SELECT p FROM Produto p WHERE p.fabricante = ?1")
	List<Produto> listarProdutosPorFabricante(Integer idFabricante);
	
	@Query("SELECT p FROM Produto p WHERE ?1 in elements(p.categorias)")
	List<Produto> listarProdutosPorCategoria(Integer idCategoria);
	
	@Query("SELECT MIN(p.preco) FROM Produto p")
	Double carregarMenorPreco();
	
	@Query("SELECT MAX(p.preco) FROM Produto p")
	Double carregarMaiorPreco();
	
	@Query("SELECT MIN(p.peso) FROM Produto p")
	Double carregarMenorPeso();
	
	@Query("SELECT MAX(p.peso) FROM Produto p")
	Double carregarMaiorPeso();
	
	List<Produto> filtrarProdutos(String nome, List<Integer> fabricantes, List<Integer> categorias, Integer precoMinimo, Integer precoMaximo, Integer pesoMinimo, Integer pesoMaximo);
	
}
