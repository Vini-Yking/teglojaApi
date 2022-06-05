package br.com.tegloja.dto;

import java.math.BigDecimal;

import br.com.tegloja.model.Produto;

public class PedidoItemRequestDTO {

	private Produto produto;
	private Integer quantidadeProduto;
	private BigDecimal valorDesconto;

	public PedidoItemRequestDTO() {

	}

	public PedidoItemRequestDTO(Produto produto, Integer quantidadeProduto, BigDecimal valorDesconto) {
		super();
		this.produto = produto;
		this.quantidadeProduto = quantidadeProduto;
		this.valorDesconto = valorDesconto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQtdproduto(Integer qtdproduto) {
		this.quantidadeProduto = qtdproduto;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

}
