package br.com.tegloja.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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

	@Column(name = "dt_compra")
	private LocalDate dataCompra;
	@Column(name = "dt_entrega")
	private LocalDate dataEntrega;

	@Column(name = "valor_total")
	private BigDecimal valortotal;
	
	@OneToMany
	@JoinColumn(name="categoria_id")
	private List<Cliente> cliente;

	public Pedido() {
	}
	

	public Pedido(Long id, StatusCompra status, LocalDate dataCompra, LocalDate dataEntrega, BigDecimal valortotal,
			List<Cliente> cliente) {
		super();
		this.id = id;
		this.status = status;
		this.dataCompra = dataCompra;
		this.dataEntrega = dataEntrega;
		this.valortotal = valortotal;
		this.cliente = cliente;
	}


	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
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
