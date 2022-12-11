package com.tcc.saboresmoduloprodutos.pojo;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Estoque implements Serializable {
	
	private static final long serialVersionUID = -1088012817146162817L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JsonProperty("produto")
	private Produto produto;
	
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAtualizacao;
	
	public Estoque() {}
	public Estoque(Produto produto) {
		setProduto(produto);
	}
	public Estoque(Produto produto, Integer quantidade) {
		setProduto(produto);
		setQuantidade(0);
		setDataAtualizacao(new Date());
	}
	public Estoque(Integer id, Produto produto, Integer quantidade, Date dataAtualizacao) {
		setId(id);
		setProduto(produto);
		setQuantidade(quantidade);
		setDataAtualizacao(dataAtualizacao);
	}
	
	public Integer getId() 				{ return id; 				}
	public Produto getProduto() 		{ return produto; 			}
	public Integer getQuantidade() 		{ return quantidade; 		}
	public Date getDataAtualizacao() 	{ return dataAtualizacao; 	}

	public void setId(Integer id) {
		this.id = id;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	@JsonProperty("dataAtualizacaoFmt")
	public String getDataAtualizacaoFmt() {
		if (this.dataAtualizacao != null) {
			DateFormat sdf = SimpleDateFormat.getDateTimeInstance(SimpleDateFormat.SHORT,SimpleDateFormat.SHORT);
			return sdf.format(getDataAtualizacao());
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
		Estoque other = (Estoque) obj;
		return Objects.equals(id, other.id);
	}
}
