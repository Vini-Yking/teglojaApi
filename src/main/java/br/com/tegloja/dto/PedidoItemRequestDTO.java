package br.com.tegloja.dto;

import java.math.BigDecimal;

import br.com.tegloja.model.Pedido;
import br.com.tegloja.model.Produto;

public class PedidoItemRequestDTO {

	private Produto produto;
	private Integer qtdproduto;
	private BigDecimal valorDesconto;
	private Pedido pedido;

	public PedidoItemRequestDTO() {

	}

	public PedidoItemRequestDTO(Produto produto, Integer qtdproduto, BigDecimal valorDesconto, Pedido pedido) {
		super();
		this.produto = produto;
		this.qtdproduto = qtdproduto;
		this.valorDesconto = valorDesconto;
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQtdproduto() {
		return qtdproduto;
	}

	public void setQtdproduto(Integer qtdproduto) {
		this.qtdproduto = qtdproduto;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
