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
import br.com.tegloja.services.PedidoItemService;

@RestController
@RequestMapping("/tegloja/itens") // "/tegloja/pedidos/{id}"
public class PedidoItemController {

	@Autowired
	private PedidoItemService pedidoItemService;

	@GetMapping
	public ResponseEntity<List<PedidoItemResponseDTO>> buscarTodos() {
		return ResponseEntity.ok(pedidoItemService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PedidoItemResponseDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(pedidoItemService.buscarPorId(id));
	}

	@GetMapping("/pagina")
	public ResponseEntity<Page<PedidoItemResponseDTO>> buscarPagina(@PageableDefault(
	// @formatter:off
					page = 0,
					size = 8) Pageable pageable) {
		// @formatter:on
		return ResponseEntity.ok(pedidoItemService.buscarPagina(pageable));
	}

	@PostMapping
	public ResponseEntity<PedidoItemResponseDTO> adicionar(@Valid @RequestBody PedidoItemRequestDTO request) {
		PedidoItemResponseDTO itemResponseDTO = pedidoItemService.adicionar(request);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(itemResponseDTO.getIdPedidoItem()).toUri();

		return ResponseEntity.created(uri).body(itemResponseDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PedidoItemResponseDTO> atualizar(@Valid @RequestBody PedidoItemRequestDTO request,
			@PathVariable Long id) {
		PedidoItemResponseDTO responseBody = pedidoItemService.atualizar(request, id);

		return ResponseEntity.ok(responseBody);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> excluir(@PathVariable Long id) {
		pedidoItemService.deletar(id);

		return ResponseEntity.ok().build();
	}

}
