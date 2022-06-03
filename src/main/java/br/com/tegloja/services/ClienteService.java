package br.com.tegloja.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tegloja.dto.ClienteRequestDTO;
import br.com.tegloja.dto.ClienteResponseDTO;
import br.com.tegloja.handler.IdNotFoundException;
import br.com.tegloja.model.Cliente;
import br.com.tegloja.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository _clienterepository;

	public void deletar(Long id) {
		buscarPorId(id);
		_clienterepository.deleteById(id);
	}
	
	public List<ClienteResponseDTO> buscarTodos() {
		List<Cliente> clientes = _clienterepository.findAll();
		// @formatter:off
		return clientes.stream()
				.map(c -> new ClienteResponseDTO(c))
				.collect(Collectors.toList());
		// @formatter:on
	}

	public ClienteResponseDTO buscarPorId(Long id) {
		Optional<Cliente> cliente = _clienterepository.findById(id);
		if (cliente.isEmpty()) {
			throw new IdNotFoundException("Não existe um cliente com esse id.");
		}
		return new ClienteResponseDTO(cliente.get());
	}

	public ClienteResponseDTO adicionar(ClienteRequestDTO clienteRequest) {
		Cliente cliente = new Cliente(clienteRequest);
		cliente = _clienterepository.save(cliente);

		return new ClienteResponseDTO(cliente);
	}

	public ClienteResponseDTO atualizar(ClienteRequestDTO clienteRequest, Long id) {
		buscarPorId(id);
		Cliente cliente = new Cliente(clienteRequest);
		cliente = _clienterepository.save(cliente);

		return new ClienteResponseDTO(cliente);
	}

}
