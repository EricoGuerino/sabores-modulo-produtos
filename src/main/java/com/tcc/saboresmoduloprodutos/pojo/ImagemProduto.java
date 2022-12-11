package com.tcc.saboresmoduloprodutos.pojo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ImagemProduto implements Serializable {
	
	private static final long serialVersionUID = -5048568767534728444L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nomeArquivo;
	private String arquivo;
	private String extensao;
	private Integer tamanho;
	private Boolean isImagemPrincipal;
	
	@OneToOne
	private Produto produto;
	
	@JsonIgnore
	@Lob
	private byte[] dados;
	
	public ImagemProduto() {}
	public ImagemProduto(MultipartFile file, Produto produto) throws Exception {
		Integer tamanho = 0;
		String arquivo = file.getOriginalFilename();
		String [] splitted = arquivo.split("\\.");
		String nomeArquivo = "", extensao = "";
		int index = 0;
		
		if (splitted.length == 1) {
			nomeArquivo = splitted[0];
			extensao = splitted[1];
		} else {
			for (String split : splitted) {
				if (index == splitted.length-1) {
					extensao = split;
				} else {
					nomeArquivo = nomeArquivo + split + ".";
				}
				index++;
			}
			nomeArquivo = nomeArquivo+",";
			nomeArquivo = nomeArquivo.replace(".,", "");
		}
		byte[] dados;
		try {
			dados = file.getBytes();
			tamanho = dados.length;
		} catch (IOException e) {
			throw new Exception("Dados não enviados");
		}
		
		setId(null);
		setNomeArquivo(nomeArquivo);
		setArquivo(arquivo);
		setTamanho(tamanho);
		setExtensao(extensao);
		setDados(dados);
		setProduto(produto);
		setIsImagemPrincipal(Boolean.FALSE);
	}
	public ImagemProduto(Produto produto) throws Exception {
		Integer tamanho = 0;
		File file = new File(ImagemProduto.class.getResource("/images/produtos/"+produto.getId()+".png").getPath());
		FileInputStream fileIN= new FileInputStream(file);
		String extensao = "png";
		String nomeArquivo = file.getName();
		String arquivo = nomeArquivo+"."+extensao;
		
		byte[] dados = IOUtils.toByteArray(fileIN);
		tamanho = dados.length;
		
		setId(null);
		setNomeArquivo(nomeArquivo);
		setArquivo(arquivo);
		setTamanho(tamanho);
		setExtensao(extensao);
		setDados(dados);
		setProduto(produto);
		setIsImagemPrincipal(Boolean.TRUE);
	}
	public Integer getId() 					{ return id; 				}
	public String getNomeArquivo() 			{ return nomeArquivo; 		}
	public String getArquivo() 				{ return arquivo; 			}
	public String getExtensao() 			{ return extensao; 			}
	public Integer getTamanho() 			{ return tamanho; 			}
	public Boolean getIsImagemPrincipal() 	{ return isImagemPrincipal;	}
	public Produto getProduto() 			{ return produto;	 		}
	public byte[] getDados() 				{ return dados; 			}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}
	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}
	public void setIsImagemPrincipal(Boolean isImagemPrincipal) {
		this.isImagemPrincipal = isImagemPrincipal;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public void setDados(byte[] dados) {
		this.dados = dados;
	}
	
	@JsonProperty("dadosBase64")
	public String getDadosBase64() {
		if (dados != null) {
			return Base64.encodeBase64String(dados);
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
		ImagemProduto other = (ImagemProduto) obj;
		return Objects.equals(id, other.id);
	}
}
