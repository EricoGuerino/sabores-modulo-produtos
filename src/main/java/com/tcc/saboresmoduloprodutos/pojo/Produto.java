package com.tcc.saboresmoduloprodutos.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 795171495972660533L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	
	@Transient 
	private Integer fabricante;
	@Transient
	private List<Integer> categorias;
	
	private Double preco;
	private Double peso;
	
	public Produto() {}
	public Produto(Integer id, String nome, String descricao, Integer fabricante, List<Integer> categorias,
			Double preco, Double peso) {
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
