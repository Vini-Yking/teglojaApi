package br.com.tegloja.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.tegloja.dto.EnderecoDTO;
import br.com.tegloja.handler.ArgumentoInvalidoException;
import br.com.tegloja.handler.DuplicateKeyException;
import br.com.tegloja.handler.NaoEncontradoException;
import br.com.tegloja.model.Endereco;
import br.com.tegloja.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public EnderecoDTO buscarInserirCep(String cep) {
		if (cep.matches("^[0-9]{8}"))
			throw new ArgumentoInvalidoException("cep inválido");

		Optional<Endereco> endereco = enderecoRepository.findByCep(cep);

		if (endereco.isPresent())
			return new EnderecoDTO(endereco.get());
		return inserirCep(cep);
	}

	public EnderecoDTO buscarCep(String cep) {
		Optional<Endereco> endereco = enderecoRepository.findByCep(cep);

		if (!endereco.isPresent()) {
			return null;
		}
		return new EnderecoDTO(endereco.get());
	}

	private EnderecoDTO inserirCep(String cep) {
		RestTemplate rs = new RestTemplate();
		String url = "http://viacep.com.br/ws/" + cep + "/json";
		Optional<Endereco> enderecoViaCep = Optional.ofNullable(rs.getForObject(url, Endereco.class));
		if (enderecoViaCep.get().getLocalidade() == null) {
			throw new ArgumentoInvalidoException("Cep não existente.");
		}
		Endereco endereco = enderecoViaCep.get();
		endereco.setCep(cep);
		endereco = enderecoRepository.save(enderecoViaCep.get());
		return new EnderecoDTO(endereco);

	}

	public EnderecoDTO inserirCep(Endereco endereco) {
		enderecoRepository.save(endereco);
		try {
			endereco = enderecoRepository.save(endereco);
		} catch (Exception e) {
			throw new DuplicateKeyException("Endereco ja cadastrado");
		}

		return new EnderecoDTO(endereco);
	}

	public void deletar(Long id) {
		if (enderecoRepository.findById(id).isEmpty()) {
			throw new NaoEncontradoException("Não existe um endereço com esse id.");
		}

		enderecoRepository.deleteById(id);
	}
}
