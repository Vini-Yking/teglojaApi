package br.com.tegloja.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tegloja.dto.PedidoItemResponseDTO;
import br.com.tegloja.dto.PedidoResponseDTO;
import br.com.tegloja.handler.IdNotFoundException;
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
		if (item.isEmpty()) {
			throw new IdNotFoundException("Não existe um item com esse id.");
		}
		return new PedidoItemResponseDTO(item.get());
	}

	public void deletar(Long id) {
		buscarPorId(id);
		_pedidoItemRepository.deleteById(id);
	}

}
