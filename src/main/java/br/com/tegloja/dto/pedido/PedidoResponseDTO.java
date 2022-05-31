package br.com.tegloja.dto.pedido;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.tegloja.enums.StatusCompra;

public class PedidoResponseDTO {

	private Long idPedido;
	private StatusCompra status;
	private LocalDate dataCompra;
	private LocalDate dataEntrega;
	private BigDecimal valortotal;
	private Long idCliente;

	public PedidoResponseDTO(Long idPedido, StatusCompra status, LocalDate dataCompra, LocalDate dataEntrega,
			BigDecimal valortotal, Long idCliente) {
		super();
		this.idPedido = idPedido;
		this.status = status;
		this.dataCompra = dataCompra;
		this.dataEntrega = dataEntrega;
		this.valortotal = valortotal;
		this.idCliente = idCliente;
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

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

}
