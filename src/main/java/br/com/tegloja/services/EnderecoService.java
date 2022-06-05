package br.com.tegloja.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.tegloja.dto.EnderecoDTO;
import br.com.tegloja.handler.ArgumentoInvalidoException;
import br.com.tegloja.handler.NaoEncontradoException;
import br.com.tegloja.model.Endereco;
import br.com.tegloja.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public EnderecoDTO buscarInserirCep(String cep) {
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
		if (enderecoViaCep.isEmpty()) {
			throw new ArgumentoInvalidoException("Cep não existente.");
		}

		String cepSemTraco = enderecoViaCep.get().getCep().replaceAll("-", "");
		enderecoViaCep.get().setCep(cepSemTraco);
		Endereco endereco = enderecoRepository.save(enderecoViaCep.get());
		return new EnderecoDTO(endereco);

	}

	public void deletar(Long id) {
		if (enderecoRepository.findById(id).isEmpty()) {
			throw new NaoEncontradoException("Não existe um endereço com esse id.");
		}

		enderecoRepository.deleteById(id);
	}
}
