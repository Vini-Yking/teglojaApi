package br.com.tegloja.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tegloja.dto.ClienteResponseDTO;
import br.com.tegloja.dto.PedidoRequestDTO;
import br.com.tegloja.dto.PedidoResponseDTO;
import br.com.tegloja.dto.ProdutoResponseDTO;
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
	/*
	 * public PedidoResponseDTO adicionar (PedidoRequestDTO pedidoRequest) {
	 * ClienteResponseDTO clienteResponseDTO =
	 * clienteService.buscarId(pedidoRequest.getCliente().getId()); Cliente cliente
	 * = new Cliente(clienteResponseDTO); Pedido pedido = new Pedido(pedidoRequest);
	 * pedido.setCliente(cliente); pedido = _pedidorepository.save(pedido);
	 * 
	 * return new PedidoResponseDTO(pedido); }
	 */

	// na inserção do pedido vai precisar ter esse cara
	// mailConfig.enviarEmail(cliente.getEmail(), "Compra Concluida!",
	// cliente.toString(),pedido.toString());

	public void deletar(Long id) {
		buscarPorId(id);
		_pedidorepository.deleteById(id);
	}
}
