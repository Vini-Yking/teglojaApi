package br.com.tegloja.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.tegloja.enums.StatusCompra;
import br.com.tegloja.model.Cliente;

public class PedidoRequestDTO {

	private Cliente cliente;

	public PedidoRequestDTO() {

	}

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
