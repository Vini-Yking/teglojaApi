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
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.tegloja.dto.PedidoItemRequestDTO;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
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

	@Min(value = 1, message = "Quantidade mínima é um ")
	@Column(nullable = false)
	private Integer quantidadeProduto;

	@Column(name = "valor_desconto")
	private BigDecimal valorDesconto;

	@Column(name = "valor_venda")
	private BigDecimal valorVenda;

	@JsonBackReference // cancelar json loop
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
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
		this.quantidadeProduto = pedidoItemRequest.getQuantidadeProduto();
		this.valorDesconto = pedidoItemRequest.getValorDesconto();
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

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
