package com.tcc.saboresmoduloprodutos.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcc.saboresmoduloprodutos.pojo.Estoque;
import com.tcc.saboresmoduloprodutos.pojo.ImagemProduto;
import com.tcc.saboresmoduloprodutos.pojo.Produto;
import com.tcc.saboresmoduloprodutos.repositories.EstoqueRepository;
import com.tcc.saboresmoduloprodutos.repositories.ImagemProdutoRepository;
import com.tcc.saboresmoduloprodutos.repositories.ProdutoRepository;

@Component
public class PopulaDados {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	@Autowired
	private ImagemProdutoRepository imagemRepository;
	
	@PostConstruct
	public void populaDados() throws Exception {
		
		List<Produto> produtos = produtoRepository.findAll();
		if (produtos.isEmpty()) {
			List<Integer> categorias1 = new ArrayList<Integer>(Arrays.asList(1,2,7));
			List<Integer> categorias2 = new ArrayList<Integer>(Arrays.asList(1,2,7));
			List<Integer> categorias3 = new ArrayList<Integer>(Arrays.asList(1,2,7));
			List<Integer> categorias4 = new ArrayList<Integer>(Arrays.asList(1,2,7));
			List<Integer> categorias5 = new ArrayList<Integer>(Arrays.asList(1,2,7));
			List<Integer> categorias6 = new ArrayList<Integer>(Arrays.asList(1,2,7));
			List<Integer> categorias7 = new ArrayList<Integer>(Arrays.asList(1,2,7));
			List<Integer> categorias8 = new ArrayList<Integer>(Arrays.asList(1,2,3));
			List<Integer> categorias9 = new ArrayList<Integer>(Arrays.asList(1,2,7));
			List<Integer> categorias10 = new ArrayList<Integer>(Arrays.asList(1,6));
			List<Integer> categorias11 = new ArrayList<Integer>(Arrays.asList(1,6));
			List<Integer> categorias12 = new ArrayList<Integer>(Arrays.asList(1,6));
			List<Integer> categorias13 = new ArrayList<Integer>(Arrays.asList(1,6));
			List<Integer> categorias14 = new ArrayList<Integer>(Arrays.asList(1,6));
			List<Integer> categorias15 = new ArrayList<Integer>(Arrays.asList(1,2,6,7,8));
			List<Integer> categorias16 = new ArrayList<Integer>(Arrays.asList(1,3,5));
			List<Integer> categorias17 = new ArrayList<Integer>(Arrays.asList(1,3,5,8));
			List<Integer> categorias18 = new ArrayList<Integer>(Arrays.asList(1,3,8));
			List<Integer> categorias19 = new ArrayList<Integer>(Arrays.asList(1,8));
			List<Integer> categorias20 = new ArrayList<Integer>(Arrays.asList(3,8));
			List<Integer> categorias21 = new ArrayList<Integer>(Arrays.asList(3,8));
			List<Integer> categorias22 = new ArrayList<Integer>(Arrays.asList(1));
			List<Integer> categorias23 = new ArrayList<Integer>(Arrays.asList(1,6,7,8));
			List<Integer> categorias24 = new ArrayList<Integer>(Arrays.asList(1,6,7,8));
			List<Integer> categorias25 = new ArrayList<Integer>(Arrays.asList(1,6,7,8));
			List<Integer> categorias26 = new ArrayList<Integer>(Arrays.asList(1,6));
			List<Integer> categorias27 = new ArrayList<Integer>(Arrays.asList(1,6));
			List<Integer> categorias28 = new ArrayList<Integer>(Arrays.asList(1,7));
			List<Integer> categorias29 = new ArrayList<Integer>(Arrays.asList(1,7));
			List<Integer> categorias30 = new ArrayList<Integer>(Arrays.asList(1,7));
			List<Integer> categorias31 = new ArrayList<Integer>(Arrays.asList(1,7));
			
			
			Produto produto1 = new Produto (1,"Doce de Leite","Doce de Leite para dietas de ingestão controlada de açúcares", 1, categorias1, 600D, 28.99);
			Produto produto2 = new Produto (2, "Doce de Leite com Coco", "Doce de Leite para dietas de ingestão controlada de açúcares", 1, categorias2, 600D,  28.99);
			Produto produto3 = new Produto (3, "Doce de Leite com Ameixa", "Doce de Leite para dietas de ingestão controlada de açúcares", 1, categorias3, 600D,  28.99);
			Produto produto4 = new Produto (4, "Cocada Cremosa", "Cocada Cremosa para dietas de ingestão controlada de açúcares", 1, categorias4, 600D,  28.99);
			Produto produto5 = new Produto (5, "Doce de Leite com Nozes", "Doce de Leite para dietas de ingestão controlada de açúcares", 1, categorias5, 600D,  28.99);
			Produto produto6 = new Produto (6, "Doce de Abóbora com Coco", "Doce de Abóbora com Coco para dietas de ingestão controlada de açúcares", 1, categorias6, 600D,  28.99);
			Produto produto7 = new Produto (7, "Pé de Moça de Colher", "Doce de Amendoin tipo pé de moça para dietas de ingestão controlada de açúcares - SEM ADIÇÃO DE AÇÚCARES", 1, categorias7, 600D, 35.99);
			Produto produto8 = new Produto (8, "Leite Condensado", "Sobremesa Láctea sabor Leite Condensado para Dietas de ingestão controlada de açúcares", 1, categorias8, 600D, 35.99);
			Produto produto9 = new Produto (9, "Beijinho", "Foundant de Leite com Coco para dietas de ingestão controlada de açúcares", 1, categorias9, 600D, 28.99);
			Produto produto10 = new Produto (10, "Goibada Cascão Diet", "Goibada Cascão Diet - Linha Premium", 2, categorias10, 600D, 44.99);
			Produto produto11 = new Produto (11, "Bananinha", "Bananinha - Sem adição de açúcar", 2, categorias11, 600D, 44.99);
			Produto produto12 = new Produto (12, "Abacaxi com Coco", "Barrinha de Fruta de Abacaxi com Coco - Sem adição de açúcar", 2, categorias12, 600D, 44.99);
			Produto produto13 = new Produto (13, "Banana com cobertura de chocolate", "Barrinha de Fruta de Banana com cobertura de chocolate", 2, categorias13, 600D, 44.99);
			Produto produto14 = new Produto (14, "Coco com cobertura de chocolate", "Barrinha de Fruta de Coco com cobertura de chocolate", 2, categorias14, 600D, 44.99);
			Produto produto15 = new Produto (15, "Paçoca", "Paçoca Moreninha do Rio", 8, categorias15, 800D, 19.99);
			Produto produto16 = new Produto (16, "Palha Italiana", "Palha Italiana Sabor Chocolate Enriquecida com Whey Protein", 5, categorias16, 30D, 14.99);
			Produto produto17 = new Produto (17, "Palha Italiana", "Palha Italiana Sabor Cookies & Cream Enriquecida com Whey Protein", 5, categorias17, 30D, 14.99);
			Produto produto18 = new Produto (18, "Caramelos de Leite", "Caramelos de Leite - Sem adição de açúcares - Contém açúcares próprios dos ingredientes", 7, categorias18, 200D, 14.99);
			Produto produto19 = new Produto (19, "Gotas de Leite", "Produzido em Avaré: Doce de Leite Pingo para dietas com insgestão controlada de açúcares", 7, categorias19, 100D, 21.99);
			Produto produto20 = new Produto (20, "Pirulito", "Pirulito Sabor Morango Zero Açúcar", 3, categorias20, 35D, 13.99);
			Produto produto21 = new Produto (21, "Merenguinho",  "Merenguinho - Sabor Original", 3, categorias21, 35D, 15.99);
			Produto produto22 = new Produto (22, "Pingo de Leite", "Foundant de Leite", 9, categorias22, 500D, 33.99);
			Produto produto23 = new Produto (23, "Cidra", "Cidra Ralada para dietas com insgestão controlada de açúcares", 4, categorias23, 400D, 28.99);
			Produto produto24 = new Produto (24, "Goiabada Cascão", "Goiabada Cascão (Jam Cascão) para dietas com insgestão controlada de açúcares", 4, categorias24, 400D, 28.99);
			Produto produto25 = new Produto (25, "Bananinha Cremosa", "Bananinha Cremosa Sem Adição de Açúcares", 2, categorias25, 100D, 21.99);
			Produto produto26 = new Produto (26, "Goiabada Cascão", "Goiabada Cascão em barra para dietas com ingestão controlada de açúcares", 4, categorias26, 500D, 25.99);
			Produto produto27 = new Produto (27, "Goiabada Cascão Zero Açúcar", "Goiabada Cascão em barra sem adição de açúcares", 1, categorias27, 150D, 21.99);
			Produto produto28 = new Produto (28, "Pé de Moça Zero Açúcar", "Pé de Moça em barra sem adição de açúcares", 1, categorias28, 150D, 21.99);
			Produto produto29 = new Produto (29, "Cocada ao Leite", "Cocada ao Leite em tablete sem adição de açúcares para dietas de ingestão controlada de açúcares", 1, categorias29, 150D, 21.99);
			Produto produto30 = new Produto (30, "Doce de Leite", "Doce de Leite em tablete sem adição de açúcares para dietas de ingestão controlada de açúcares", 1, categorias30, 150D, 21.99);
			Produto produto31 = new Produto (31, "YES! Milk Shake Instantâneo", "YES! Milk Shake Instantâneo - Sabor Mo", 6, categorias31, 80D, 38.99);
			
			produtoRepository.saveAll(
					Arrays.asList(
							produto1,  produto2,  produto3,  produto4,  produto5,  produto6,  produto7,
							produto8,  produto9,  produto10, produto11, produto12, produto13, produto14,
							produto15, produto16, produto17, produto18, produto19, produto20, produto21,
							produto22, produto23, produto24, produto25, produto26, produto27, produto28,
							produto29, produto30, produto31));
			
			Estoque estoque1 = new Estoque(produto1, 25);
			Estoque estoque2 = new Estoque(produto2, 25);
			Estoque estoque3 = new Estoque(produto3, 25);
			Estoque estoque4 = new Estoque(produto4, 25);
			Estoque estoque5 = new Estoque(produto5, 25);
			Estoque estoque6 = new Estoque(produto6, 25);
			Estoque estoque7 = new Estoque(produto7, 25);
			Estoque estoque8 = new Estoque(produto8, 25);
			Estoque estoque9 = new Estoque(produto9, 25);
			Estoque estoque10 = new Estoque(produto10, 25);
			Estoque estoque11 = new Estoque(produto11, 25);
			Estoque estoque12 = new Estoque(produto12, 25);
			Estoque estoque13 = new Estoque(produto13, 25);
			Estoque estoque14 = new Estoque(produto14, 25);
			Estoque estoque15 = new Estoque(produto15, 25);
			Estoque estoque16 = new Estoque(produto16, 25);
			Estoque estoque17 = new Estoque(produto17, 25);
			Estoque estoque18 = new Estoque(produto18, 25);
			Estoque estoque19 = new Estoque(produto19, 25);
			Estoque estoque20 = new Estoque(produto20, 25);
			Estoque estoque21 = new Estoque(produto21, 25);
			Estoque estoque22 = new Estoque(produto22, 25);
			Estoque estoque23 = new Estoque(produto23, 25);
			Estoque estoque24 = new Estoque(produto24, 25);
			Estoque estoque25 = new Estoque(produto25, 25);
			Estoque estoque26 = new Estoque(produto26, 25);
			Estoque estoque27 = new Estoque(produto27, 25);
			Estoque estoque28 = new Estoque(produto28, 25);
			Estoque estoque29 = new Estoque(produto29, 25);
			Estoque estoque30 = new Estoque(produto30, 25);
			Estoque estoque31 = new Estoque(produto31, 25);
			
			estoqueRepository.saveAll(
					Arrays.asList(
							estoque1,  estoque2,  estoque3,  estoque4,  estoque5,  estoque6,  estoque7,
							estoque8,  estoque9,  estoque10, estoque11, estoque12, estoque13, estoque14,
							estoque15, estoque16, estoque17, estoque18, estoque19, estoque20, estoque21,
							estoque22, estoque23, estoque24, estoque25, estoque26, estoque27, estoque28,
							estoque29, estoque30, estoque31));
			
			ImagemProduto imagem1 = new ImagemProduto(produto1);
			ImagemProduto imagem2 = new ImagemProduto(produto2);
			ImagemProduto imagem3 = new ImagemProduto(produto3);
			ImagemProduto imagem4 = new ImagemProduto(produto4);
			ImagemProduto imagem5 = new ImagemProduto(produto5);
			ImagemProduto imagem6 = new ImagemProduto(produto6);
			ImagemProduto imagem7 = new ImagemProduto(produto7);
			ImagemProduto imagem8 = new ImagemProduto(produto8);
			ImagemProduto imagem9 = new ImagemProduto(produto9);
			ImagemProduto imagem10 = new ImagemProduto(produto10);
			ImagemProduto imagem11 = new ImagemProduto(produto11);
			ImagemProduto imagem12 = new ImagemProduto(produto12);
			ImagemProduto imagem13 = new ImagemProduto(produto13);
			ImagemProduto imagem14 = new ImagemProduto(produto14);
			ImagemProduto imagem15 = new ImagemProduto(produto15);
			ImagemProduto imagem16 = new ImagemProduto(produto16);
			ImagemProduto imagem17 = new ImagemProduto(produto17);
			ImagemProduto imagem18 = new ImagemProduto(produto18);
			ImagemProduto imagem19 = new ImagemProduto(produto19);
			ImagemProduto imagem20 = new ImagemProduto(produto20);
			ImagemProduto imagem21 = new ImagemProduto(produto21);
			ImagemProduto imagem22 = new ImagemProduto(produto22);
			ImagemProduto imagem23 = new ImagemProduto(produto23);
			ImagemProduto imagem24 = new ImagemProduto(produto24);
			ImagemProduto imagem25 = new ImagemProduto(produto25);
			ImagemProduto imagem26 = new ImagemProduto(produto26);
			ImagemProduto imagem27 = new ImagemProduto(produto27);
			ImagemProduto imagem28 = new ImagemProduto(produto28);
			ImagemProduto imagem29 = new ImagemProduto(produto29);
			ImagemProduto imagem30 = new ImagemProduto(produto30);
			ImagemProduto imagem31 = new ImagemProduto(produto31);
			
			imagemRepository.saveAll(
					Arrays.asList(
							imagem1,  imagem2,  imagem3,  imagem4,  imagem5,  imagem6,  imagem7,
							imagem8,  imagem9,  imagem10, imagem11, imagem12, imagem13, imagem14,
							imagem15, imagem16, imagem17, imagem18, imagem19, imagem20, imagem21,
							imagem22, imagem23, imagem24, imagem25, imagem26, imagem27, imagem28,
							imagem29, imagem30, imagem31));
			
			
		}
	}
	
}
