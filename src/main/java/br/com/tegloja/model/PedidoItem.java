package br.com.tegloja.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.tegloja.dto.PedidoItemRequestDTO;

@Entity
@Table(name = "pedido_itens")
public class PedidoItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_produto")
	private Produto produto;

	@Column(nullable = false)
	private Integer quantidadeProduto;

	// @Transient
	// private BigDecimal subTotal;

	private BigDecimal valorDesconto;
	private BigDecimal valorVenda;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	public PedidoItem() {
	}

	public PedidoItem(Long id, Produto produto, Integer quantidadeProduto, BigDecimal valorDesconto,
			BigDecimal valorVenda, Pedido pedido) {
		super();
		this.id = id;
		this.produto = produto;
		this.quantidadeProduto = quantidadeProduto;
		this.valorDesconto = valorDesconto;
		this.valorVenda = valorVenda;
		this.pedido = pedido;
	}

	public PedidoItem(PedidoItemRequestDTO pedidoItemRequest) {
		this.pedido = pedidoItemRequest.getPedido();
		this.produto = pedidoItemRequest.getProduto();
		this.quantidadeProduto = pedidoItemRequest.getQtdproduto();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQtdproduto() {
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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

}
