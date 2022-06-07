package br.com.tegloja.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PedidoItemRequestDTO {

	@NotNull(message = "Informe idProduto.")
	private Long idProduto;

	@NotNull(message = "Informe quantidadeProduto.")
	@Min(value = 1, message = "quantidadeProduto mínima é 1.")
	private Integer quantidadeProduto;

	@NotNull(message = "Informe valorDesconto.")
	@DecimalMin(value = "0.0", message = "valorDesconto mínimo é zero")
	private BigDecimal valorDesconto;

	public PedidoItemRequestDTO() {

	}

	public PedidoItemRequestDTO(Long idProduto, Integer quantidadeProduto, BigDecimal valorDesconto) {
		super();
		this.idProduto = idProduto;
		this.quantidadeProduto = quantidadeProduto;
		this.valorDesconto = valorDesconto;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

}
