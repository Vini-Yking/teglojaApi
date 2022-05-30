package br.com.tegloja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tegloja.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository _pedidorepository;
}
