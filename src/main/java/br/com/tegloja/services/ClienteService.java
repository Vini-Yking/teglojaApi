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
import br.com.tegloja.handler.NaoEncontradoException;
import br.com.tegloja.model.Cliente;
import br.com.tegloja.model.Endereco;
import br.com.tegloja.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository _clienteRepository;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private MailConfig mailConfig;

	public void deletar(Long id) {
		buscarPorId(id);
		_clienteRepository.deleteById(id);
	}

	public List<ClienteResponseDTO> buscarTodos() {
		List<Cliente> clientes = _clienteRepository.findAll();
		// @formatter:off
		return clientes.stream()
				.map(cliente -> new ClienteResponseDTO(cliente))
				.collect(Collectors.toList());
		// @formatter:on
	}

	public Page<ClienteResponseDTO> buscarPagina(Pageable page) {
		Page<Cliente> clientes = _clienteRepository.findAll(page);

		return clientes.map(cliente -> new ClienteResponseDTO(cliente));
	}

	public ClienteResponseDTO buscarPorId(Long id) {
		Optional<Cliente> cliente = _clienteRepository.findById(id);
		if (cliente.isEmpty()) {
			throw new NaoEncontradoException("Não existe um cliente com esse id.");
		}
		return new ClienteResponseDTO(cliente.get());
	}

	public ClienteResponseDTO adicionar(ClienteRequestDTO clienteRequest) {
		Cliente cliente = new Cliente(clienteRequest);
		EnderecoDTO enderecoDTO = enderecoService.buscarInserirCep(clienteRequest.getCep());
		Endereco endereco = new Endereco(enderecoDTO);

		cliente.setEndereco(endereco);
		_clienteRepository.saveAndFlush(cliente);
		/**
		 * Não foi possivel enviar email por limitação do google
		 * mailConfig.enviarEmail(cliente.getEmail(), "Cadastrado efetuado com sucesso",
		 * cliente.toString());
		 */

		return new ClienteResponseDTO(cliente);
	}

	public ClienteResponseDTO atualizar(ClienteRequestDTO clienteRequest, Long id) {
		buscarPorId(id);
		Cliente cliente = new Cliente(clienteRequest);
		cliente.setId(id);
		cliente = _clienteRepository.save(cliente);

		return new ClienteResponseDTO(cliente);
	}

}
