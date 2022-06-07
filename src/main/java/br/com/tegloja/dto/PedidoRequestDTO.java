package br.com.tegloja.dto;

import javax.validation.constraints.NotBlank;

public class PedidoRequestDTO {

	@NotBlank(message = "Informe idCliente.")
	private Long idCliente;

	@NotBlank(message = "Informe codigoPagamento.")
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
