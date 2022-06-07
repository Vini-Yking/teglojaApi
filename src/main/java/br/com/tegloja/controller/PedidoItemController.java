package br.com.tegloja.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tegloja.dto.PedidoItemRequestDTO;
import br.com.tegloja.dto.PedidoItemResponseDTO;
import br.com.tegloja.services.PedidoItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tegloja/itens") // "/tegloja/pedidos/{id}"
@Api(value = "Itens dos pedidos")
@CrossOrigin(origins = "*")
public class PedidoItemController {

	@Autowired
	private PedidoItemService pedidoItemService;

	@GetMapping
	@ApiOperation(value = "Retorna uma lista de todos os itens de pedidos")
	public ResponseEntity<List<PedidoItemResponseDTO>> buscarTodos() {
		return ResponseEntity.ok(pedidoItemService.buscarTodos());
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um item de pedido")
	public ResponseEntity<PedidoItemResponseDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(pedidoItemService.buscarPorId(id));
	}

	@GetMapping("/pagina")
	@ApiOperation(value = "Retorna uma lista paginada de todos os pedidos")
	public ResponseEntity<Page<PedidoItemResponseDTO>> buscarPagina(@PageableDefault(
	// @formatter:off
			page = 0,
			size = 8) Pageable pageable) {
		// @formatter:on
		return ResponseEntity.ok(pedidoItemService.buscarPagina(pageable));
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza um item de pedido")
	public ResponseEntity<PedidoItemResponseDTO> atualizar(@Valid @RequestBody PedidoItemRequestDTO request,
			@PathVariable Long id) {
		PedidoItemResponseDTO responseBody = pedidoItemService.atualizar(request, id);

		return ResponseEntity.ok(responseBody);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Apaga um item de pedido")
	public ResponseEntity<Object> excluir(@PathVariable Long id) {
		pedidoItemService.deletar(id);

		return ResponseEntity.noContent().build();
	}

}
