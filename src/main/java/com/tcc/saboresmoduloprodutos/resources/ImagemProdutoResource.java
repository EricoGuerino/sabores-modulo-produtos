package com.tcc.saboresmoduloprodutos.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tcc.saboresmoduloprodutos.pojo.ImagemProduto;
import com.tcc.saboresmoduloprodutos.pojo.Produto;
import com.tcc.saboresmoduloprodutos.service.ImagemProdutoService;
import com.tcc.saboresmoduloprodutos.service.ProdutoService;
import com.tcc.saboresmoduloprodutos.utils.Util;

@RestController
@RequestMapping("/imagens")
public class ImagemProdutoResource {
	@Autowired
	private ImagemProdutoService imagemProdutoService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listarEstoque() {
		List<ImagemProduto> imagens = imagemProdutoService.listarTodos();
		return Util.buildResponse(HttpStatus.OK).body(imagens);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> obterPorId(@PathVariable("id")Integer id) throws Exception {
		ImagemProduto imagem = imagemProdutoService.obterPeloId(id);
		return Util.buildResponse(HttpStatus.OK).body(imagem);
	}
	
	@RequestMapping(value = "/{produtoId}", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE+";charset=UTF-8")
	public ResponseEntity<?> insert(@RequestParam("dados") MultipartFile dados, @PathVariable("produtoId") Integer id) throws Exception {
		ImagemProduto imagem = null;
		Produto produto = produtoService.obterPeloId(id);
		try {
			imagem = new ImagemProduto(dados, produto);
			imagem = imagemProdutoService.insert(imagem);
		} catch (Exception e) {
			throw e;
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(imagem.getId()).toUri();
		return Util.buildResponse(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody ImagemProduto imagem, @PathVariable("id")Integer id) {
		imagem.setId(id);
		imagem = imagemProdutoService.update(imagem);
		return Util.buildResponse(HttpStatus.NO_CONTENT).build();
	}
	
	@RequestMapping(value = "/alterarImagemPrincipal/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable("id")Integer id) {
		
		imagemProdutoService.alterarImagemPrincipal(id);
		
		return Util.buildResponse(HttpStatus.NO_CONTENT).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id")Integer id) {
		ImagemProduto imagemDeletada = imagemProdutoService.obterPeloId(id);
		Boolean isImagemPrincipal = imagemDeletada.getIsImagemPrincipal();
		
		imagemProdutoService.delete(id);
		if (isImagemPrincipal) {
			List<ImagemProduto> imagens = imagemProdutoService.listarTodos();
			if (imagens != null && !imagens.isEmpty()) {
				ImagemProduto imagem = imagens.get(0);
				imagem.setIsImagemPrincipal(Boolean.TRUE);
				imagemProdutoService.update(imagem);
			}
		}
		return Util.buildResponse(HttpStatus.NO_CONTENT).build();
	}
	
	@RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> obterImagemPorProduto(@PathVariable("id")Integer id) throws Exception {
		ImagemProduto imagem = imagemProdutoService.obterPorProduto(id);
		return Util.buildResponse(HttpStatus.OK).body(imagem);
	}
	
	@RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listarImagemPorProduto(@PathVariable("id")Integer id) throws Exception {
		List<ImagemProduto> imagens = imagemProdutoService.listarPorProduto(id);
		return Util.buildResponse(HttpStatus.OK).body(imagens);
	}
}
