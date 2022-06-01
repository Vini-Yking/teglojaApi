package br.com.tegloja.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido_itens")
public class PedidoItens {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;
	@Column(nullable = false)
	private Integer qtdproduto;
	private BigDecimal valorDesconto;
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	public PedidoItens() {

	}

	public PedidoItens(Long id, Produto produto, Integer qtdproduto, BigDecimal valorDesconto, Pedido pedido) {
		super();
		this.id = id;
		this.produto = produto;
		this.qtdproduto = qtdproduto;
		this.valorDesconto = valorDesconto;
		this.pedido = pedido;
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
