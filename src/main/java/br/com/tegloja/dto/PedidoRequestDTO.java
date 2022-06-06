package br.com.tegloja.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.tegloja.model.Cliente;

public class PedidoRequestDTO {
	
	private Long clienteId;
	@JsonIgnore
	private Cliente cliente;
	
	private Long formaPagamento;

	public PedidoRequestDTO() {

	}

	public PedidoRequestDTO(Long clienteId, Long codigoPagamento) {
		super();
		this.clienteId = clienteId;
		this.formaPagamento = codigoPagamento;
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

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

}
