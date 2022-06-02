package br.com.tegloja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tegloja.handler.ExceptionById;
import br.com.tegloja.repository.PedidoItensRepository;

@Service
public class PedidoItensService {

	@Autowired
	private PedidoItensRepository _pedidoItensRepository;
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private ProdutoService produtoService;
	
	public void deletar(Long id) {
		if (_pedidoItensRepository.findById(id).isEmpty()) {
			throw new ExceptionById();
		}
		_pedidoItensRepository.deleteById(id);
	}
	
}
