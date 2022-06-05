package br.com.tegloja.dto;

import java.math.BigDecimal;

import br.com.tegloja.model.Produto;

public class PedidoItemRequestDTO {

	private Produto produto;
	private Integer quantidadeProduto;
	private BigDecimal valorDesconto;
	private String tipoPagamento;

	public PedidoItemRequestDTO() {

	}

	public PedidoItemRequestDTO(Produto produto, Integer quantidadeProduto, BigDecimal valorDesconto,String tipoPagamento) {
		super();
		this.produto = produto;
		this.quantidadeProduto = quantidadeProduto;
		this.valorDesconto = valorDesconto;
		this.tipoPagamento = tipoPagamento;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
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
