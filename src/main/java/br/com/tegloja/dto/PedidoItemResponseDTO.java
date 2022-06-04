package br.com.tegloja.dto;

import java.math.BigDecimal;

import br.com.tegloja.model.Pedido;
import br.com.tegloja.model.PedidoItem;
import br.com.tegloja.model.Produto;

public class PedidoItemResponseDTO {

	private Long idPedidoItem;
	private Pedido pedido;
	private Produto produto;
	private Integer quantidadeProduto;
	private BigDecimal desconto;
	private BigDecimal valorVenda;

	public PedidoItemResponseDTO() {

	}

	public PedidoItemResponseDTO(Long idPedidoItem, Pedido pedido, Produto produto, Integer quantidadeProduto,
			BigDecimal desconto, BigDecimal valorVenda) {
		super();
		this.idPedidoItem = idPedidoItem;
		this.pedido = pedido;
		this.produto = produto;
		this.quantidadeProduto = quantidadeProduto;
		this.desconto = desconto;
		this.valorVenda = valorVenda;
	}

	public PedidoItemResponseDTO(PedidoItem pedidoItem) {
		this.desconto = pedidoItem.getValorDesconto();
		this.idPedidoItem = pedidoItem.getId();
		this.pedido = pedidoItem.getPedido();
		this.produto = pedidoItem.getProduto();
		this.quantidadeProduto = pedidoItem.getQuantidadeProduto();
		this.valorVenda = pedidoItem.getValorVenda();
	}

	public Long getIdPedidoItem() {
		return idPedidoItem;
	}

	public void setIdPedidoItem(Long idPedidoItem) {
		this.idPedidoItem = idPedidoItem;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

}
