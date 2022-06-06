package br.com.tegloja.dto;

public class PedidoRequestDTO {

	private Long idCliente;
	private Long codigoPagamento;

	public PedidoRequestDTO() {

	}

	public PedidoRequestDTO(Long idCliente, Long codigoPagamento) {
		super();
		this.idCliente = idCliente;
		this.codigoPagamento = codigoPagamento;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getCodigoPagamento() {
		return codigoPagamento;
	}

	public void setCodigoPagamento(Long codigoPagamento) {
		this.codigoPagamento = codigoPagamento;
	}

}