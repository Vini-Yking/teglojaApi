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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.tegloja.dto.PedidoRequestDTO;
import br.com.tegloja.dto.PedidoResponseDTO;
import br.com.tegloja.enums.FormaPagamento;
import br.com.tegloja.enums.StatusCompra;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
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

	@Column(name = "tipo_pagamento")
	@Enumerated(EnumType.ORDINAL)
	private FormaPagamento formaPagamento;
	
	@Transient
	private String pagamento;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@JsonManagedReference // cancelar JSON loop
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)

	private List<PedidoItem> itens;

	public Pedido() {

	}

	public Pedido(Long id, StatusCompra status, LocalDate dataCompra, LocalDate dataEntrega, BigDecimal valortotal,
			Cliente cliente, FormaPagamento tipoPagamento, List<PedidoItem> itens) {
		this.id = id;
		this.status = status;
		this.dataCompra = dataCompra;
		this.dataEntrega = dataEntrega;
		this.valortotal = valortotal;
		this.cliente = cliente;
		this.itens = itens;
	}

	public Pedido(PedidoRequestDTO pedidoRequest) {
		this.cliente.setId(pedidoRequest.getIdCliente());
	}

	public Pedido(PedidoResponseDTO pedidoResponse) {
		this.id = pedidoResponse.getIdPedido();
		this.cliente = pedidoResponse.getCliente();
		this.dataCompra = pedidoResponse.getDataCompra();
		this.dataEntrega = pedidoResponse.getDataEntrega();
		this.status = pedidoResponse.getStatus();
		this.valortotal = pedidoResponse.getValortotal();
		this.formaPagamento = pedidoResponse.getFormaPagamento();
		this.itens = pedidoResponse.getItens();
	}

	@Override // envio de email do pedido
	public String toString() {
		return "/nPedido Realizado no dia" + dataCompra + "\nSerá entregue em " + dataEntrega + "\nvalortotal R$"
				+ valortotal + "";
	}
	

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
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

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public List<PedidoItem> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItem> itens) {
		this.itens = itens;
	}

}
