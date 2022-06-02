package br.com.tegloja.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tegloja.dto.CategoriaResponseDTO;
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

	public ClienteResponseDTO buscarPorId(Long id) {
		Optional<Cliente> cliente = _clienterepository.findById(id);
		if (cliente.isEmpty()) {
			throw new IdNotFoundException("Não existe um cliente com esse id.");
		}
		return new ClienteResponseDTO(cliente.get());
	}
}
