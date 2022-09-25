package com.tcc.saboresmoduloprodutos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.saboresmoduloprodutos.pojo.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
