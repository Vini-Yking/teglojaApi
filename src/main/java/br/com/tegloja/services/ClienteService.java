package br.com.tegloja.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.tegloja.backend.config.MailConfig;
import br.com.tegloja.dto.ClienteRequestDTO;
import br.com.tegloja.dto.ClienteResponseDTO;
import br.com.tegloja.dto.EnderecoDTO;
import br.com.tegloja.handler.IdNotFoundException;
import br.com.tegloja.model.Cliente;
import br.com.tegloja.model.Endereco;
import br.com.tegloja.repository.ClienteRepository;
import br.com.tegloja.repository.EnderecoRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository _clienterepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private MailConfig mailConfig;

	public void deletar(Long id) {
		buscarPorId(id);
		_clienterepository.deleteById(id);
	}

	public List<ClienteResponseDTO> buscarTodos() {
		List<Cliente> clientes = _clienterepository.findAll();
		// @formatter:off
		return clientes.stream()
				.map(cliente -> new ClienteResponseDTO(cliente))
				.collect(Collectors.toList());
		// @formatter:on
	}

	public Page<ClienteResponseDTO> buscarPagina(Pageable page) {
		Page<Cliente> clientes = _clienterepository.findAll(page);

		return clientes.map(cliente -> new ClienteResponseDTO(cliente));
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
		EnderecoDTO enderecoDTO = enderecoService.buscar(clienteRequest.getCep());
		Endereco endereco = new Endereco(enderecoDTO);
		cliente = _clienterepository.save(cliente);
		
		/**
		 * Não foi possivel enviar email por limitação do google
		 * mailConfig.enviarEmail(cliente.getEmail(), "Cadastrado efetuado com sucesso", cliente.toString());
		 */
		
		
		return new ClienteResponseDTO(cliente,endereco);
	}

	public ClienteResponseDTO atualizar(ClienteRequestDTO clienteRequest, Long id) {
		buscarPorId(id);
		Cliente cliente = new Cliente(clienteRequest);
		cliente.setId(id);
		cliente = _clienterepository.save(cliente);

		return new ClienteResponseDTO(cliente);
	}

}
