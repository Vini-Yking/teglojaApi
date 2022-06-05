package br.com.tegloja.controller;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tegloja.dto.ProdutoRequestDTO;
import br.com.tegloja.dto.ProdutoResponseDTO;
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

	/**
	 * @Autowired private FotoService fotoService;
	 */

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

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um produto")
	public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(produtoService.buscarPorId(id));
	}

	// TODO
	// @GetMapping("/{id}/pedidos")
	// public ResponseEntity<ProdutoResponseDTO> buscarPedidosProduto(@PathVariable
	// Long id) {
	// }

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza um produto")
	public ResponseEntity<ProdutoResponseDTO> atualizar(@RequestBody ProdutoRequestDTO produtoRequest, Long id) {
		return ResponseEntity.ok(produtoService.atualizar(produtoRequest, id));
	}

	/**
	 * @GetMapping("/{id}/foto") public ResponseEntity<byte[]>
	 * buscarPorFoto(@PathVariable Long id) { Foto foto =
	 * fotoService.buscarPorId(id); // busco a foto no banco HttpHeaders headers =
	 * new HttpHeaders();// crio o cabeçalho headers.add("content-type",
	 * foto.getTipo());// tipo do arquivo png,jpge headers.add("content-length",
	 * String.valueOf(foto.getDados().length));// tamanho do arquivo 1kb 2mb
	 * 
	 * return new ResponseEntity<>(foto.getDados(), headers, HttpStatus.OK);//
	 * retorno na resposta a foto, o cabeçalho // e a resposta do servidor }
	 */

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Adiciona um produto")
	public ResponseEntity<ProdutoResponseDTO> adicionar(@Valid @RequestBody ProdutoRequestDTO produtoRequest) {
		ProdutoResponseDTO produtoResponseDTO = produtoService.adicionar(produtoRequest);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(produtoResponseDTO.getIdProduto()).toUri();
		return ResponseEntity.created(uri).body(produtoResponseDTO);
	}

	/**
	 * @PostMapping
	 * @ResponseStatus(HttpStatus.CREATED) public ResponseEntity<ProdutoResponseDTO>
	 *                                     adicionarComFoto(@Valid @RequestParam
	 *                                     MultipartFile file,
	 * @RequestPart ProdutoRequestDTO produtoRequest) throws IOException {
	 *              ProdutoResponseDTO produtoResponseDTO =
	 *              produtoService.adicionarComFoto(produtoRequest, file); URI uri =
	 *              ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	 *              .buildAndExpand(produtoResponseDTO.getIdProduto()).toUri();
	 *              return ResponseEntity.created(uri).body(produtoResponseDTO); }
	 */

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Apaga um produto")
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		produtoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
