package br.com.tegloja.dto;

import br.com.tegloja.enums.FormaPagamento;
import br.com.tegloja.model.Cliente;

public class PedidoRequestDTO {

	private Cliente cliente;
	private Long codigoPagamento;

	public PedidoRequestDTO() {

	}

	public PedidoRequestDTO(Cliente cliente, Long codigoPagamento) {
		super();
		this.cliente = cliente;
		this.codigoPagamento = codigoPagamento;
	}

	public Long getCodigoPagamento() {
		return codigoPagamento;
	}

	public void setCodigoPagamento(Long codigoPagamento) {
		this.codigoPagamento = codigoPagamento;
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
