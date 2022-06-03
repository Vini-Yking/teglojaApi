package br.com.tegloja.controller;


import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
	


}
