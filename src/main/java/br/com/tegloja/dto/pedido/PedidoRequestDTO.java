package br.com.tegloja.dto.pedido;

import br.com.tegloja.model.Cliente;

public class PedidoRequestDTO {

	private Cliente cliente;

	public PedidoRequestDTO(Cliente cliente) {
		super();
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
