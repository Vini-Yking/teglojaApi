package br.com.tegloja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tegloja.handler.IdNotFoundException;
import br.com.tegloja.repository.PedidoItemRepository;

@Service
public class PedidoItemService {

	@Autowired
	private PedidoItemRepository _pedidoItensRepository;
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private ProdutoService produtoService;
	
	public void deletar(Long id) {
		if (_pedidoItensRepository.findById(id).isEmpty()) {
			throw new IdNotFoundException();
		}
		_pedidoItensRepository.deleteById(id);
	}
	
}
