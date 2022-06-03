package br.com.tegloja.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.tegloja.enums.StatusCompra;
import br.com.tegloja.model.Cliente;
import br.com.tegloja.model.Pedido;

public class PedidoResponseDTO {

	private Long idPedido;
	private StatusCompra status;
	private LocalDate dataCompra;
	private LocalDate dataEntrega;
	private BigDecimal valortotal;
	private Cliente Cliente;

	public PedidoResponseDTO() {

	}

	public PedidoResponseDTO(Long idPedido, StatusCompra status, LocalDate dataCompra, LocalDate dataEntrega,
			BigDecimal valortotal, Cliente cliente) {
		super();
		this.idPedido = idPedido;
		this.status = status;
		this.dataCompra = dataCompra;
		this.dataEntrega = dataEntrega;
		this.valortotal = valortotal;
		this.Cliente = cliente;
	}

	public PedidoResponseDTO(Pedido pedido) {
		this.dataCompra = pedido.getDataCompra();
		this.dataEntrega = pedido.getDataEntrega();
		this.idPedido = pedido.getId();
		this.status = pedido.getStatus();
		this.valortotal = pedido.getValortotal();
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
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

	public BigDecimal getValortotal() {
		return valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

	public Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}

}
