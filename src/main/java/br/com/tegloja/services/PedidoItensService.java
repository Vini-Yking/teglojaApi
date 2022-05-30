package br.com.tegloja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tegloja.repository.PedidoItensRepository;

@Service
public class PedidoItensService {

	@Autowired
	private PedidoItensRepository _pedidoItensRepository;
}
