package br.com.tegloja.dto;

import java.math.BigDecimal;

public class PedidoItemRequestDTO {

	private Long idProduto;
	private Integer quantidadeProduto;
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

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
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

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}
	

}
