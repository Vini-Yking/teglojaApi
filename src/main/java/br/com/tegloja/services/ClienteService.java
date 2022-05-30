package br.com.tegloja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tegloja.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository _clienterepository;
}
