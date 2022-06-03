package br.com.tegloja.controller;

<<<<<<< HEAD
import java.net.URI;
=======

import java.util.List;

>>>>>>> c9228880e4195270f26c999274b3c02db7a4d0e3

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
=======
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> c9228880e4195270f26c999274b3c02db7a4d0e3
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tegloja.dto.ClienteRequestDTO;
import br.com.tegloja.dto.ClienteResponseDTO;
import br.com.tegloja.services.ClienteService;

import br.com.tegloja.model.Cliente;
import br.com.tegloja.repository.ClienteRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;



@RestController
@RequestMapping("/tegloja/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente inserir(@Valid @RequestBody Cliente cliente ) {
	    return clienteRepository.save(cliente);
	}
	
	@GetMapping
	public List<Cliente>listar(){
		return clienteRepository.findAll();
	}
	


	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity<ClienteResponseDTO> adicionar(@Valid @RequestBody ClienteRequestDTO request) {
		ClienteResponseDTO clienteResponseDTO = clienteService.adicionar(request);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(clienteResponseDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(clienteResponseDTO);
	}
}
