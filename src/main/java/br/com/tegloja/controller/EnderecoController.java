package br.com.tegloja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tegloja.dto.EnderecoDTO;
import br.com.tegloja.model.Endereco;
import br.com.tegloja.services.EnderecoService;

@RestController
@RequestMapping("/tegloja/cep")
public class EnderecoController {
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping("{cep}")
	public ResponseEntity<EnderecoDTO> buscar(@PathVariable String cep){
		EnderecoDTO enderecoDTO = enderecoService.buscar(cep);
		if (enderecoDTO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(enderecoDTO);
	}
	//troquei para ao invés de retornar todos os dados da api Endereco só os que realmente a gente precisa no DTO
}
