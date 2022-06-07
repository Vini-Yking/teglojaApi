package br.com.tegloja.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tegloja.dto.CategoriaRequestDTO;
import br.com.tegloja.dto.CategoriaResponseDTO;
import br.com.tegloja.dto.ProdutoResponseDTO;
import br.com.tegloja.services.CategoriaService;
import br.com.tegloja.services.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tegloja/categorias")
@Api(value = "Categorias de Produtos")
@CrossOrigin(origins = "*")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	private ProdutoService produtoService;

	@GetMapping
	@ApiOperation(value = "Retorna uma lista de todos as categorias")
	public ResponseEntity<List<CategoriaResponseDTO>> buscarTodos() {
		return ResponseEntity.ok(categoriaService.buscarTodos());
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna uma categoria")
	public ResponseEntity<CategoriaResponseDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(categoriaService.buscarPorId(id));
	}

	@GetMapping("/pagina")
	@ApiOperation(value = "Retorna uma lista paginada de todos as categorias")
	public ResponseEntity<Page<CategoriaResponseDTO>> buscarPagina(@PageableDefault(
	// @formatter:off
		sort = "categoria",
		direction = Sort.Direction.ASC,
		page = 0,
		size = 8
		)Pageable pageable) {
	// @formatter:on
		return ResponseEntity.ok(categoriaService.buscarPagina(pageable));
	}

	@GetMapping("/pesquisar")
	@ApiOperation(value = "Retorna uma lista paginada de categorias buscadas pelo nome")
	public ResponseEntity<Page<CategoriaResponseDTO>> buscarPorNome(@PageableDefault(
	// @formatter:off
		sort = "categoria",
		direction = Sort.Direction.ASC,
		page = 0,
		size = 8
		)Pageable pageable, @RequestParam(defaultValue = "*") String nome) {
	// @formatter:on	
		return ResponseEntity.ok(categoriaService.buscarPorNome(pageable, nome));
	}

	@GetMapping("/{id}/produtos")
	@ApiOperation(value = "Retorna os produtos de uma categoria")
	public ResponseEntity<List<ProdutoResponseDTO>> buscarProdutosCategoria(@PathVariable Long id) {
		return ResponseEntity.ok(produtoService.buscarPorCategoria(id));
	}

	@GetMapping("/{id}/produtos/pagina")
	@ApiOperation(value = "Retorna os produtos paginados de uma categoria")
	public ResponseEntity<Page<ProdutoResponseDTO>> buscarProdutosCategoriaPaginado(@PageableDefault(
	// @formatter:off
		sort = "nomeProduto",
		direction = Sort.Direction.ASC,
		page = 0,
		size = 8)Pageable pageable, @PathVariable Long id) {
	// @formatter:off
		return ResponseEntity.ok(produtoService.buscarPorCategoriaPaginado(pageable,id));
	}

	@PostMapping
	@ApiOperation(value = "Adiciona uma categoria")
	public ResponseEntity<CategoriaResponseDTO> adicionar(@Valid @RequestBody CategoriaRequestDTO request) {
		CategoriaResponseDTO categoriaResponseDTO = categoriaService.adicionar(request);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(categoriaResponseDTO.getId()).toUri();

		return ResponseEntity.created(uri).body(categoriaResponseDTO);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza uma categoria")
	public ResponseEntity<CategoriaResponseDTO> atualizar(@Valid @RequestBody CategoriaRequestDTO request,
			@PathVariable Long id) {
		CategoriaResponseDTO responseBody = categoriaService.atualizar(request, id);

		return ResponseEntity.ok(responseBody);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Apaga uma categoria")
	public ResponseEntity<Object> excluir(@PathVariable Long id) {
		categoriaService.deletar(id);

		return ResponseEntity.noContent().build();
	}

}
