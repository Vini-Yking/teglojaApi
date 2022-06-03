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

import br.com.tegloja.dto.PedidoRequestDTO;
import br.com.tegloja.dto.PedidoResponseDTO;
import br.com.tegloja.services.PedidoService;

@RestController
@RequestMapping("/tegloja/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<List<PedidoResponseDTO>> buscarTodos() {
		return ResponseEntity.ok(pedidoService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PedidoResponseDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(pedidoService.buscarPorId(id));
	}

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

	@PostMapping
	public ResponseEntity<PedidoResponseDTO> adicionar(@Valid @RequestBody PedidoRequestDTO request) {
		PedidoResponseDTO pedidoResponseDTO = pedidoService.adicionar(request);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(pedidoResponseDTO.getIdPedido()).toUri();

		return ResponseEntity.created(uri).body(pedidoResponseDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PedidoResponseDTO> atualizar(@Valid @RequestBody PedidoRequestDTO request,
			@PathVariable Long id) {
		PedidoResponseDTO responseBody = pedidoService.atualizar(request, id);

		return ResponseEntity.ok(responseBody);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> excluir(@PathVariable Long id) {
		pedidoService.deletar(id);

		return ResponseEntity.ok().build();
	}

}
