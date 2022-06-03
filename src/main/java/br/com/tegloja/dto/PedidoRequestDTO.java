package br.com.tegloja.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.tegloja.enums.StatusCompra;
import br.com.tegloja.model.Cliente;

public class PedidoRequestDTO {
	
	private StatusCompra status;
	private LocalDate dataCompra;
	private LocalDate dataEntrega;
	private BigDecimal valorTotal;
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

	public StatusCompra getStatus() {
		return status;
	}

	public void setStatus(StatusCompra status) {
		this.status = status;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
