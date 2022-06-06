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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tegloja.dto.PedidoItemRequestDTO;
import br.com.tegloja.dto.PedidoItemResponseDTO;
import br.com.tegloja.dto.PedidoRequestDTO;
import br.com.tegloja.dto.PedidoResponseDTO;
import br.com.tegloja.handler.EnumValidationException;
import br.com.tegloja.services.PedidoItemService;
import br.com.tegloja.services.PedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController // /tegloga/pedidos/id/itens
@Api(value = "Pedidos cadastrados")
@RequestMapping("/tegloja/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private PedidoItemService pedidoItemService;

	@GetMapping
	public ResponseEntity<List<PedidoResponseDTO>> buscarTodos() {
		return ResponseEntity.ok(pedidoService.buscarTodos());
	}
	@ApiOperation(value = "Retorna uma lista de todos os produtos")
	@GetMapping("/{id}")
	public ResponseEntity<PedidoResponseDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(pedidoService.buscarPorIdPedido(id));
	}
	@ApiOperation(value = "retorna um pedido pelo id")
	@GetMapping("/{id}/itens")
	public ResponseEntity<List<PedidoItemResponseDTO>> listarItensPorIdPedido(@PathVariable Long id) {
		return ResponseEntity.ok(pedidoItemService.buscarPorIdPedido(id));
	}
	@ApiOperation(value = "Retorna uma lista de todos os produtos")
	@GetMapping("/pagina")
	public ResponseEntity<Page<PedidoResponseDTO>> buscarPagina(@PageableDefault(
	// @formatter:off
					sort = "dataCompra",
					direction = Sort.Direction.DESC,
					page = 0,
					size = 8
					)Pageable pageable) {
		// @formatter:on
		return ResponseEntity.ok(pedidoService.buscarPagina(pageable));
	}
	@ApiOperation(value = "Retorna uma lista de todos os produtos")
	@PostMapping
	public ResponseEntity<PedidoResponseDTO> iniciarPedido(@Valid @RequestBody PedidoRequestDTO request) {
		PedidoResponseDTO pedidoResponseDTO = pedidoService.iniciarPedidoVazio(request);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(pedidoResponseDTO.getIdPedido()).toUri();

		return ResponseEntity.created(uri).body(pedidoResponseDTO);
	}
	@ApiOperation(value = "Retorna uma lista de todos os produtos")
	@PostMapping("/item/{id}")
	public ResponseEntity<PedidoItemResponseDTO> adicionarItem(@PathVariable Long id, @RequestBody PedidoItemRequestDTO requestItem){
		PedidoItemResponseDTO pedidoItemResponseDTO = pedidoItemService.adicionar(id, requestItem);
		return ResponseEntity.ok().body(pedidoItemResponseDTO);
	}
	@ApiOperation(value = "Retorna uma lista de todos os produtos")
	@PutMapping("/{id}")
	public ResponseEntity<PedidoResponseDTO> encerrarPedido(@Valid @PathVariable Long id,@RequestBody PedidoRequestDTO requestItem) throws EnumValidationException {
		PedidoResponseDTO responseBody = pedidoService.finalizarPedido(id,requestItem);
		return ResponseEntity.ok(responseBody);
	}
		
	@ApiOperation(value = "Retorna uma lista de todos os produtos")
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> excluir(@PathVariable Long id) {
		pedidoService.deletar(id);

		return ResponseEntity.noContent().build();
	}

}
