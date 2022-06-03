package br.com.tegloja.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tegloja.backend.config.MailConfig;
import br.com.tegloja.dto.ClienteResponseDTO;
import br.com.tegloja.dto.PedidoRequestDTO;
import br.com.tegloja.dto.PedidoResponseDTO;
import br.com.tegloja.handler.IdNotFoundException;
import br.com.tegloja.model.Cliente;
import br.com.tegloja.model.Pedido;
import br.com.tegloja.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository _pedidorepository;

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private MailConfig mailConfig;

	public List<PedidoResponseDTO> buscarTodos() {
		List<Pedido> pedidos = _pedidorepository.findAll();
		// @formatter:off
		return pedidos.stream()
				.map(p -> new PedidoResponseDTO(p))
				.collect(Collectors.toList());
		// @formatter:on
	}

	public PedidoResponseDTO buscarPorId(Long id) {
		Optional<Pedido> pedido = _pedidorepository.findById(id);
		if (pedido.isEmpty()) {
			throw new IdNotFoundException("Não existe um pedido com esse id.");
		}
		return new PedidoResponseDTO(pedido.get());
	}

	public PedidoResponseDTO adicionar(PedidoRequestDTO pedidoRequest) {
		ClienteResponseDTO clienteResponseDTO = clienteService.buscarPorId(pedidoRequest
				.getCliente().getId());

		Cliente cliente = new Cliente(clienteResponseDTO);
		Pedido pedido = new Pedido(pedidoRequest);
		
		pedido.setCliente(cliente);
		pedido = _pedidorepository.save(pedido);
		mailConfig.enviarEmail(cliente.getEmail(), "Compra Concluida!",
				pedido.toString());
		return new PedidoResponseDTO(pedido);
	}

	public PedidoResponseDTO atualizar(PedidoRequestDTO pedidoRequest, Long id) {
		buscarPorId(id);
		Pedido pedido = new Pedido(pedidoRequest);
		pedido = _pedidorepository.save(pedido);
		return new PedidoResponseDTO(pedido);
	}

	public void deletar(Long id) {
		buscarPorId(id);
		_pedidorepository.deleteById(id);
	}
}
