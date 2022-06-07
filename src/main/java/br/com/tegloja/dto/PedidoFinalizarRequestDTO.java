package br.com.tegloja.dto;

import javax.validation.constraints.NotBlank;

public class PedidoFinalizarRequestDTO {

	@NotBlank(message = "Informe codigoPagamento: 1- Crédito parcelado 2- Crédito a vista 3- Débito 4- Pix 5- Boleto.")
	private Long codigoPagamento;

	public PedidoFinalizarRequestDTO() {

	}

	public PedidoFinalizarRequestDTO(@NotBlank(message = "Informe codigoPagamento.") Long codigoPagamento) {
		super();
		this.codigoPagamento = codigoPagamento;
	}

	public Long getCodigoPagamento() {
		return codigoPagamento;
	}

	public void setCodigoPagamento(Long codigoPagamento) {
		this.codigoPagamento = codigoPagamento;
	}

}
