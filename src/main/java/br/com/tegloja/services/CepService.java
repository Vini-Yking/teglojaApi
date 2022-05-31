package br.com.tegloja.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.tegloja.model.Endereco;

@FeignClient(url= "https://viacep.com.br/ws/" , name = "viacep")
public interface CepService {

	@GetMapping("{cep}/json")
	Endereco buscaEnderecoCep(@PathVariable("cep") String cep);
}
