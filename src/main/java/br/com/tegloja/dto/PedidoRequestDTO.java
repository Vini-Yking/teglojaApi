package br.com.tegloja.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.tegloja.enums.FormaPagamento;
import br.com.tegloja.enums.StatusCompra;
import br.com.tegloja.model.Cliente;

public class PedidoRequestDTO {

	private Cliente cliente;
	private FormaPagamento formaPagamento;

	public PedidoRequestDTO() {

	}

	public PedidoRequestDTO(Cliente cliente) {
		super();
		this.cliente = cliente;
	}
	
	

	public PedidoRequestDTO(FormaPagamento tipoPagamento) {
		super();
		this.formaPagamento = tipoPagamento;
	}
	

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento tipoPagamento) {
		this.formaPagamento = tipoPagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


}
