package br.com.tegloja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tegloja.dto.ClienteResponseDTO;
import br.com.tegloja.dto.PedidoRequestDTO;
import br.com.tegloja.dto.PedidoResponseDTO;
import br.com.tegloja.dto.ProdutoResponseDTO;
import br.com.tegloja.handler.ExceptionById;
import br.com.tegloja.model.Cliente;
import br.com.tegloja.model.Pedido;
import br.com.tegloja.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository _pedidorepository;
	
	@Autowired
	private ClienteService clienteService;
	
	
	/*public PedidoResponseDTO adicionar (PedidoRequestDTO pedidoRequest) {
		ClienteResponseDTO clienteResponseDTO = clienteService.buscarId(pedidoRequest.getCliente().getId());
		Cliente cliente = new Cliente(clienteResponseDTO);
		Pedido pedido = new Pedido(pedidoRequest);
		pedido.setCliente(cliente);
		pedido = _pedidorepository.save(pedido);

		return new PedidoResponseDTO(pedido);
	}*/
	
	
	//na inserção do pedido vai precisar ter esse cara
	//mailConfig.enviarEmail(cliente.getEmail(), "Compra Concluida!", cliente.toString(),pedido.toString());
	
	public void deletar(Long id) {
		if (_pedidorepository.findById(id).isEmpty()) {
			throw new ExceptionById();
		}
		_pedidorepository.deleteById(id);
	}
}
