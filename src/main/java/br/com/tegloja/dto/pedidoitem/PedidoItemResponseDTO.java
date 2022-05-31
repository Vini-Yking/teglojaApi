package br.com.tegloja.dto.pedidoitem;

import java.math.BigDecimal;

public class PedidoItemResponseDTO {

	private Long idPedidoItem;
	private Long idPedido;
	private Long idProduto;
	private Integer qtdproduto;
	private BigDecimal desconto;

	public PedidoItemResponseDTO(Long idPedidoItem, Long idPedido, Long idProduto, Integer qtdproduto,
			BigDecimal desconto) {
		super();
		this.idPedidoItem = idPedidoItem;
		this.idPedido = idPedido;
		this.idProduto = idProduto;
		this.qtdproduto = qtdproduto;
		this.desconto = desconto;
	}

	public Long getIdPedidoItem() {
		return idPedidoItem;
	}

	public void setIdPedidoItem(Long idPedidoItem) {
		this.idPedidoItem = idPedidoItem;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Integer getQtdproduto() {
		return qtdproduto;
	}

	public void setQtdproduto(Integer qtdproduto) {
		this.qtdproduto = qtdproduto;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

}
