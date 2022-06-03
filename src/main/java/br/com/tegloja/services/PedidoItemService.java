package br.com.tegloja.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.tegloja.dto.PedidoItemRequestDTO;
import br.com.tegloja.dto.PedidoItemResponseDTO;
import br.com.tegloja.dto.PedidoResponseDTO;
import br.com.tegloja.dto.ProdutoResponseDTO;
import br.com.tegloja.enums.StatusCompra;
import br.com.tegloja.handler.IdNotFoundException;
import br.com.tegloja.model.Pedido;
import br.com.tegloja.model.PedidoItem;
import br.com.tegloja.repository.PedidoItemRepository;

@Service
public class PedidoItemService {

	@Autowired
	private PedidoItemRepository _pedidoItemRepository;

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private ProdutoService produtoService;

	public PedidoItemResponseDTO buscarPorId(Long id) {
		Optional<PedidoItem> item = _pedidoItemRepository.findById(id);
		if (item.isEmpty())
			throw new IdNotFoundException("Não existe um item com esse id.");

		return new PedidoItemResponseDTO(item.get());
	}

	public List<PedidoItemResponseDTO> buscarPorIdPedido(Long idPedido) {
		PedidoResponseDTO pedidoResponse = pedidoService.buscarPorId(idPedido);
		Pedido pedido = new Pedido(pedidoResponse);
		List<PedidoItem> itens = _pedidoItemRepository.findByPedido(pedido);
		if (itens.isEmpty())
			throw new IdNotFoundException("Não existe itens neste pedido.");

		// @formatter:off
		return itens.stream()
				.map(item -> new PedidoItemResponseDTO(item))
				.collect(Collectors.toList());
		// @formatter:on
	}

	public Page<PedidoItemResponseDTO> buscarPagina(Pageable page) {
		Page<PedidoItem> itens = _pedidoItemRepository.findAll(page);

		return itens.map(item -> new PedidoItemResponseDTO(item));
	}

	public List<PedidoItemResponseDTO> buscarTodos() {
		List<PedidoItem> itens = _pedidoItemRepository.findAll();
		// @formatter:off
		return itens.stream()
				.map(item -> new PedidoItemResponseDTO(item))
				.collect(Collectors.toList());
		// @formatter:on
	}

	public void deletar(Long id) {
		buscarPorId(id);
		_pedidoItemRepository.deleteById(id);
	}

	public PedidoItemResponseDTO adicionar(PedidoItemRequestDTO pedidoItemRequest) {
		// Checa o pedido
		PedidoResponseDTO pedidoResponse = pedidoService.buscarPorId(pedidoItemRequest.getPedido().getId());
		if (pedidoResponse.getStatus().equals(StatusCompra.FINALIZADO)) {
			// throw new PedidoFinalizadoException("Pedido já finalizado.");
		}
		PedidoItem pedidoItem = new PedidoItem(pedidoItemRequest);
		ProdutoResponseDTO produto = produtoService.buscarPorId(pedidoItem.getPedido().getId());

		BigDecimal valor = produto.getValorUnit().multiply(BigDecimal.valueOf(pedidoItem.getQtdproduto()));
		if (!pedidoItem.getValorDesconto().equals(null))
			valor = valor.subtract(pedidoItem.getValorDesconto());

		pedidoItem.setValorVenda(valor);
		pedidoItem = _pedidoItemRepository.save(pedidoItem);

		return new PedidoItemResponseDTO(pedidoItem);
	}

	public PedidoItemResponseDTO atualizar(PedidoItemRequestDTO pedidoItemRequest, Long id) {
		buscarPorId(id);
		PedidoItem pedidoItem = new PedidoItem(pedidoItemRequest);
		pedidoItem.setId(id);
		pedidoItem = _pedidoItemRepository.save(pedidoItem);

		return new PedidoItemResponseDTO(pedidoItem);
	}
}
