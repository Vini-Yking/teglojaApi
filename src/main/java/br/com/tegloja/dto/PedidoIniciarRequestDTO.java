package br.com.tegloja.dto;

import javax.validation.constraints.NotBlank;

public class PedidoIniciarRequestDTO {

	@NotBlank(message = "Informe idCliente.")
	private Long idCliente;

	public PedidoIniciarRequestDTO() {

	}

	public PedidoIniciarRequestDTO(Long idCliente) {
		super();
		this.idCliente = idCliente;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

}
