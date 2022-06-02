package br.com.tegloja.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tegloja.dto.PedidoResponseDTO;
import br.com.tegloja.model.Pedido;
import br.com.tegloja.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository _pedidorepository;

	public List<PedidoResponseDTO> listar() {
		List<Pedido> pedidos = _pedidorepository.findAll();
		// @formatter:off
		return pedidos.stream()
				.map(p -> new PedidoResponseDTO(p))
				.collect(Collectors.toList());
		// @formatter:on
	}

	public PedidoResponseDTO buscar(Long id) {
		Optional<Pedido> pedido = _pedidorepository.findById(id);
		return pedido.isPresent() ? new PedidoResponseDTO(pedido.get()) : null;
	}

}
