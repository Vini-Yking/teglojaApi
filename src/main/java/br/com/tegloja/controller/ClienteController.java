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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tegloja.dto.ClientePutRequestDTO;
import br.com.tegloja.dto.ClienteRequestDTO;
import br.com.tegloja.dto.ClienteResponseDTO;
import br.com.tegloja.dto.PedidoResponseDTO;
import br.com.tegloja.services.ClienteService;
import br.com.tegloja.services.PedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tegloja/clientes")
@Api(value = "Clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	@ApiOperation(value = "Retorna uma lista de todos os clientes")
	public ResponseEntity<List<ClienteResponseDTO>> buscarTodos() {
		return ResponseEntity.ok(clienteService.buscarTodos());
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um cliente")
	public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(clienteService.buscarPorId(id));
	}

	@GetMapping("/paginas")
	@ApiOperation(value = "Retorna uma lista paginada de todos os clientes")
	public ResponseEntity<Page<ClienteResponseDTO>> buscarTodosPaginado(@PageableDefault(
	// @formatter:off
					sort = "nome",
					direction = Sort.Direction.ASC,
					page = 0,
					size = 8
					)Pageable pageable) {
		// @formatter:on
		return ResponseEntity.ok(clienteService.buscarPagina(pageable));
	}

	@GetMapping("/pesquisar")
	@ApiOperation(value = "Retorna uma lista paginada de clientes pesquisados por nome")
	public ResponseEntity<Page<ClienteResponseDTO>> buscarPorNome(@PageableDefault(
	// @formatter:off
					sort = "nome",
					direction = Sort.Direction.ASC,
					page = 0,
					size = 8
					)Pageable pageable, @RequestParam String nome) {
		// @formatter:on
		return ResponseEntity.ok(clienteService.buscarPorNome(pageable, nome));
	}

	@GetMapping("/clientes/{id}/pedidos")
	@ApiOperation(value = "Retorna uma lista de pedidos do cliente")
	public ResponseEntity<List<PedidoResponseDTO>> buscarPedidosCliente(@PathVariable Long id) {
		return ResponseEntity.ok(pedidoService.buscarPorIdCliente(id));
	}

	@GetMapping("/clientes/{id}/pedidos/paginas")
	@ApiOperation(value = "Retorna uma lista paginada de pedidos do cliente")
	public ResponseEntity<Page<PedidoResponseDTO>> buscarPedidosPaginadosCliente(@PathVariable Long id,
			@PageableDefault(page = 0, size = 8) Pageable pageable) {
		return ResponseEntity.ok(pedidoService.buscarPorIdClientePaginado(id, pageable));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Adiciona um cliente")
	public ResponseEntity<ClienteResponseDTO> adicionar(@Valid @RequestBody ClienteRequestDTO request) {
		ClienteResponseDTO clienteResponseDTO = clienteService.adicionar(request);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(clienteResponseDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(clienteResponseDTO);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza um cliente")
	public ResponseEntity<ClienteResponseDTO> atualizar(@Valid @RequestBody ClientePutRequestDTO request,
			@PathVariable Long id) {
		ClienteResponseDTO responseBody = clienteService.atualizar(request, id);

		return ResponseEntity.ok(responseBody);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Apaga um cliente")
	public ResponseEntity<Object> excluir(@PathVariable Long id) {
		clienteService.deletar(id);

		return ResponseEntity.noContent().build();
	}

}
