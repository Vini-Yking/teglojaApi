package br.com.tegloja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tegloja.dto.ClienteResponseDTO;
import br.com.tegloja.dto.EnderecoDTO;
import br.com.tegloja.services.EnderecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tegloja/cep")
@Api(value = "CEPs cadastrados")
@CrossOrigin(origins = "*")
public class EnderecoController {
	@Autowired
	private EnderecoService enderecoService;


	@GetMapping
	@ApiOperation(value = "Retorna uma lista de todos os enderecos")
	public ResponseEntity<List<EnderecoDTO>> buscarTodos() {
		return ResponseEntity.ok(enderecoService.buscarTodos());
	}
	
	@GetMapping("{cep}")
	@ApiOperation(value = "Retorna um CEP")
	public ResponseEntity<EnderecoDTO> buscarPorCep(@PathVariable String cep) {
		EnderecoDTO enderecoDTO = enderecoService.buscarInserirCep(cep);
		if (enderecoDTO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(enderecoDTO);
	}

	// troquei para ao invés de retornar todos os dados da api Endereco só os que
	// realmente a gente precisa no DTO
}
