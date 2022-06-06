package br.com.tegloja.dto;

import br.com.tegloja.enums.FormaPagamento;
import br.com.tegloja.model.Cliente;

public class PedidoRequestDTO {

	private Cliente cliente;
	private Long formaPagamento;

	public PedidoRequestDTO() {

	}

	public PedidoRequestDTO(Cliente cliente, Long codigoPagamento) {
		super();
		this.cliente = cliente;
		this.codigoPagamento = codigoPagamento;
	}

	public PedidoRequestDTO(Long tipoPagamento) {
		super();
		this.formaPagamento = tipoPagamento;
	}

	public Long getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(Long tipoPagamento) {
		this.formaPagamento = tipoPagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
