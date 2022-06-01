package br.com.tegloja.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tegloja.dto.produto.ProdutoRequestDTO;
import br.com.tegloja.dto.produto.ProdutoResponseDTO;
import br.com.tegloja.services.ProdutoService;

@RestController
@RequestMapping("/tegloja/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<ProdutoResponseDTO>> listar() {
		return ResponseEntity.ok(produtoService.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoResponseDTO> buscar(@PathVariable Long id) {
		return ResponseEntity.ok(produtoService.buscar(id));
	}

	public ResponseEntity<ProdutoResponseDTO> atualizar(@RequestBody ProdutoRequestDTO produtoRequest, Long id) {
		ProdutoResponseDTO responseBody = produtoService.atualizar(produtoRequest, id);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(responseBody.getIdProduto()).toUri();
		return ResponseEntity.created(uri).body(responseBody);
	}

	@PostMapping
	public ResponseEntity<ProdutoResponseDTO> adicionar(@Valid @RequestBody ProdutoRequestDTO produtoRequest) {
		ProdutoResponseDTO produtoResponseDTO = produtoService.adicionar(produtoRequest);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(produtoResponseDTO.getIdProduto()).toUri();
		return ResponseEntity.created(uri).body(produtoResponseDTO);
	}

}
