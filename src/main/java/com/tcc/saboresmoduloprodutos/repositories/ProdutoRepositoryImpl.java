package com.tcc.saboresmoduloprodutos.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tcc.saboresmoduloprodutos.pojo.Produto;

@Component
public class ProdutoRepositoryImpl {
	
	@PersistenceContext
	private EntityManager em;
	
	//@Autowired
	//private ProdutoRepository produtoRepository;
	
	@Transactional
	@Modifying
	public void alteraProdutosLote(List<Produto> produtos) {
		for (Produto produto : produtos) {
			em.merge(produto);
		}
	}
	
	public List<Produto> filtrarProdutos(
			String nome, List<Integer> fabricantes, List<Integer> categorias, 
			Integer precoMinimo, Integer precoMaximo, Integer pesoMinimo, Integer pesoMaximo) {
		
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT p FROM Produto p ");
		hql.append("WHERE 1=1");
		if (fabricantes != null && !fabricantes.isEmpty()) {
			hql.append(" AND p.fabricante IN (:fabricantes) ");
		}
		if (nome != null && !nome.equals("") && !nome.equals(" ")) {
			hql.append(" AND UPPER(p.nome) LIKE '%"+nome.toUpperCase()+"%'");
		}
		if (pesoMinimo != null) {
			hql.append(" AND p.peso >= :peso_minimo" );
		}
		if (pesoMaximo != null) {
			hql.append(" AND p.peso <= :peso_maximo" );
		}
		if (precoMinimo != null) {
			hql.append(" AND p.preco >= :preco_minimo" );
		}
		if (precoMaximo != null) {
			hql.append(" AND p.preco <= :preco_maximo " );
		}
		hql.append("ORDER BY p.id");
		
		try {
			TypedQuery<Produto> query = em.createQuery(hql.toString(), Produto.class);
			if (fabricantes != null && !fabricantes.isEmpty()) {
				query.setParameter("fabricantes", fabricantes);
			}
			if (pesoMinimo != null) {
				query.setParameter("peso_minimo", pesoMinimo.doubleValue());
			}
			if (pesoMaximo != null) {
				query.setParameter("peso_maximo", pesoMaximo.doubleValue());
			}
			if (precoMinimo != null) {
				query.setParameter("preco_minimo", precoMinimo.doubleValue());
			}
			if (precoMaximo != null) {
				query.setParameter("preco_maximo", precoMaximo.doubleValue());
			}
			
			List<Produto> produtos = query.getResultList();
			
			if (categorias != null && !categorias.isEmpty()) {
				List<Produto> produtosFinal = new ArrayList<Produto>();
				for (Produto prod : produtos) {
					Boolean achouCategoria = Boolean.FALSE;
					if (prod.getCategorias() != null && !prod.getCategorias().isEmpty()) {
						for (Integer cat : prod.getCategorias()) {
							if (categorias.contains(cat)) {
								achouCategoria = Boolean.TRUE;
							}
						}
					}
					
					if (achouCategoria) {
						produtosFinal.add(prod);
					}
				}
				
				return produtosFinal;
			} else {
				return produtos;
			}
		} catch (Exception e) {
			throw e;
		}
	}
}
