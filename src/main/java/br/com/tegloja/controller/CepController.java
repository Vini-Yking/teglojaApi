package br.com.tegloja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tegloja.dto.CepDTO;
import br.com.tegloja.model.Endereco;
import br.com.tegloja.services.CepService;

@RestController
@RequestMapping("/tegloja/cep")
public class CepController {
	
	@Autowired
	private CepService _cepService;
	
	@GetMapping("/{cep}")
	public ResponseEntity<CepDTO> localizarCep(@PathVariable String cep){
	
		Endereco endereco = _cepService.buscaEnderecoCep(cep);
		CepDTO enderecoCep = new CepDTO(endereco);
		return enderecoCep != null ? ResponseEntity.ok().body(enderecoCep) : ResponseEntity.notFound().build();
		
	}
	//troquei para ao invés de retornar todos os dados da api Endereco só os que realmente a gente precisa no DTO
}
