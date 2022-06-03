package br.com.tegloja.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.tegloja.dto.PedidoRequestDTO;
import br.com.tegloja.dto.PedidoResponseDTO;
import br.com.tegloja.enums.StatusCompra;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "status_pedido", nullable = false)
	private StatusCompra status;

	@Column(name = "data_compra")
	private LocalDate dataCompra;

	@Column(name = "data_entrega")
	private LocalDate dataEntrega;

	@Column(name = "valor_total")
	private BigDecimal valortotal;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<PedidoItem> itens;

	// @ManyToMany
	// @JoinTable(name = "pedido_item", joinColumns = @JoinColumn(name =
	// "id_pedido"), inverseJoinColumns = @JoinColumn(name = "id_produto"))
	// private List<Produto> produtos;

	public Pedido() {
	}

	public Pedido(Long id, StatusCompra status, LocalDate dataCompra, LocalDate dataEntrega, BigDecimal valortotal,
			Cliente cliente) {
		super();
		this.id = id;
		this.status = status;
		this.dataCompra = dataCompra;
		this.dataEntrega = dataEntrega;
		this.valortotal = valortotal;
		this.cliente = cliente;
	}

	public Pedido(PedidoRequestDTO pedidoRequest) {
		this.status = pedidoRequest.getStatus();
		this.dataCompra = pedidoRequest.getDataCompra();
		this.dataEntrega = pedidoRequest.getDataEntrega();
		this.valortotal = pedidoRequest.getValorTotal();
		this.cliente = pedidoRequest.getCliente();
	}

	public Pedido(PedidoResponseDTO pedidoResponse) {
		this.cliente = pedidoResponse.getCliente();
		this.dataCompra = pedidoResponse.getDataCompra();
		this.dataEntrega = pedidoResponse.getDataEntrega();
		this.id = pedidoResponse.getIdPedido();
		this.status = pedidoResponse.getStatus();
		this.valortotal = pedidoResponse.getValortotal();
	}

	@Override // envio de email do pedido
	public String toString() {
		return "/nPedido Realizado no dia" + dataCompra + "\nSerá entregue em " + dataEntrega + "\nvalortotal R$"
				+ valortotal + "";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatusCompra getStatus() {
		return status;
	}

	public void setStatus(StatusCompra status) {
		this.status = status;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public BigDecimal getValortotal() {
		return valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

}
