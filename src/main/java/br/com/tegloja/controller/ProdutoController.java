package br.com.tegloja.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tegloja.dto.PedidoItemResponseDTO;
import br.com.tegloja.dto.ProdutoRequestDTO;
import br.com.tegloja.dto.ProdutoResponseDTO;
import br.com.tegloja.model.Foto;
import br.com.tegloja.services.FotoService;
import br.com.tegloja.services.PedidoItemService;
import br.com.tegloja.services.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tegloja/produtos")
@Api(value = "Produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private PedidoItemService pedidoItemService;

	@Autowired
	private FotoService fotoService;

	@GetMapping
	@ApiOperation(value = "Retorna uma lista de todos os produtos")
	public ResponseEntity<List<ProdutoResponseDTO>> buscarTodos() {
		return ResponseEntity.ok(produtoService.buscarTodos());
	}

	@GetMapping("/pagina")
	@ApiOperation(value = "Retorna uma lista paginada de todos os produtos")
	public ResponseEntity<Page<ProdutoResponseDTO>> buscarPagina(@PageableDefault(
	// @formatter:off
			sort = "nomeProduto",
			direction = Sort.Direction.ASC,
			page = 0,
			size = 8)Pageable pageable) {
	// @formatter:on
		return ResponseEntity.ok(produtoService.buscarPagina(pageable));
	}

	@GetMapping("/pesquisar")
	@ApiOperation(value = "Retorna uma lista paginada de produtos pesquisados por nome")
	public ResponseEntity<Page<ProdutoResponseDTO>> buscarPorNome(@PageableDefault(
	// @formatter:off
			sort = "nomeProduto",
			direction = Sort.Direction.ASC,
			page = 0,
			size = 8)Pageable pageable, @RequestParam String nome) {
	// @formatter:on
		return ResponseEntity.ok(produtoService.buscarPorNome(pageable, nome));
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um produto")
	public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(produtoService.buscarPorId(id));
	}

	@GetMapping("/{id}/pedidos")
	@ApiOperation(value = "Retorna uma lista paginada de todos os itens de pedido contendo o produto")
	public ResponseEntity<Page<PedidoItemResponseDTO>> buscarPedidosProduto(@PageableDefault(
	// @formatter:off
			page = 0,
			size = 8)Pageable pageable, @PathVariable Long idProduto) {
	// @formatter:on
		return ResponseEntity.ok(pedidoItemService.buscarPorIdProduto(pageable, idProduto));
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza um produto")
	public ResponseEntity<ProdutoResponseDTO> atualizar(@RequestBody ProdutoRequestDTO produtoRequest,@PathVariable Long id) {
		return ResponseEntity.ok(produtoService.atualizar(produtoRequest, id));
	}

	@GetMapping("/{id}/foto")
	@ApiOperation(value = "Retorna a foto de um produto")
	public ResponseEntity<byte[]> buscarFoto(@PathVariable Long id) {
		Foto foto = fotoService.buscarPorProduto(id);
		return ResponseEntity.ok(foto.getDados());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Adiciona um produto")

	public ResponseEntity<ProdutoResponseDTO> adicionar(@Valid @RequestBody ProdutoRequestDTO produtoRequest) {
		ProdutoResponseDTO produtoResponseDTO = produtoService.adicionar(produtoRequest);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(produtoResponseDTO.getIdProduto()).toUri();
		return ResponseEntity.created(uri).body(produtoResponseDTO);
	}

	@PostMapping("/{id}/foto")
	@ApiOperation(value = "Adiciona uma imagem ao produto")
	public ResponseEntity<Foto> adicionarImagem(Long idProduto, @RequestParam MultipartFile file) throws IOException {
		Foto foto = fotoService.inserir(idProduto, file);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(foto.getId()).toUri();
		return ResponseEntity.created(uri).body(foto);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Apaga um produto")
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		produtoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
