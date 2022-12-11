package com.tcc.saboresmoduloprodutos.pojo;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 795171495972660533L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	
	private Integer fabricante;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Integer> categorias;
	
	private Double preco;
	private Double peso;
	
	@JsonIgnore
	@OneToOne(mappedBy = "produto")
	private Estoque estoque;
	
	@OneToOne
	private ImagemProduto imagem;
	
	public Produto() {}
	public Produto(Integer id, String nome, String descricao, Integer fabricante, List<Integer> categorias,
			Double peso, Double preco) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.fabricante = fabricante;
		this.categorias = categorias;
		this.preco = preco;
		this.peso = peso;
	}
	public Integer getId() 					{ return id; 			}
	public String getNome() 				{ return nome; 			}
	public String getDescricao() 			{ return descricao; 	}
	public Integer getFabricante() 			{ return fabricante; 	}
	public List<Integer> getCategorias() 	{ return categorias; 	}
	public Double getPreco() 				{ return preco; 		}
	public Double getPeso() 				{ return peso; 			}
	public Estoque getEstoque() 			{ return estoque;		}
	public ImagemProduto getImagem() 		{ return imagem;		}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setFabricante(Integer fabricante) {
		this.fabricante = fabricante;
	}
	public void setCategorias(List<Integer> categorias) {
		this.categorias = categorias;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	public void setImagem(ImagemProduto imagem) {
		this.imagem = imagem;
	}
	
	@JsonProperty("pesoFmt")
	public String getPesoFmt() {
		if (this.peso != null) {
			Integer peso = this.peso.intValue();
			return peso.toString()+"gr";
		}
		return "";
	}
	
	@JsonProperty("precoFmt")
	public String getPrecoFmt() {
		if (this.preco != null) {
			
			Locale locale = new Locale("pt", "BR");
			NumberFormat cf = NumberFormat.getCurrencyInstance();
			cf.setMaximumFractionDigits(2);
			cf.setCurrency(Currency.getInstance(locale));
			return cf.format(this.preco);
		}
		return "";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
}
