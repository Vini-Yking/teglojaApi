package br.com.tegloja.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tegloja.dto.PedidoItemRequestDTO;
import br.com.tegloja.dto.PedidoItemResponseDTO;
import br.com.tegloja.handler.IdNotFoundException;
import br.com.tegloja.model.PedidoItem;
import br.com.tegloja.repository.PedidoItemRepository;

@Service
public class PedidoItemService {

	@Autowired
	private PedidoItemRepository _pedidoItemRepository;

	public PedidoItemResponseDTO buscarPorId(Long id) {
		Optional<PedidoItem> item = _pedidoItemRepository.findById(id);
		if (item.isEmpty()) {
			throw new IdNotFoundException("Não existe um item com esse id.");
		}
		return new PedidoItemResponseDTO(item.get());
	}

	public List<PedidoItemResponseDTO> buscarTodos() {
		List<PedidoItem> itens = _pedidoItemRepository.findAll();
		// @formatter:off
		return itens.stream()
				.map(p -> new PedidoItemResponseDTO(p))
				.collect(Collectors.toList());
		// @formatter:on
	}

	public void deletar(Long id) {
		buscarPorId(id);
		_pedidoItemRepository.deleteById(id);
	}

	public PedidoItemResponseDTO adicionar(PedidoItemRequestDTO pedidoItemRequest) {
		PedidoItem pedidoItem = new PedidoItem(pedidoItemRequest);
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
