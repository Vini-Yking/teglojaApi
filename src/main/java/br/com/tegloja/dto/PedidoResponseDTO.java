package br.com.tegloja.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.tegloja.enums.FormaPagamento;
import br.com.tegloja.enums.StatusCompra;
import br.com.tegloja.model.Cliente;
import br.com.tegloja.model.Pedido;
import br.com.tegloja.model.PedidoItem;

public class PedidoResponseDTO {

	private Long idPedido;
	private StatusCompra status;
	private LocalDate dataCompra;
	private LocalDate dataEntrega;
	private BigDecimal valortotal;
	@JsonIgnore
	private FormaPagamento formaPagamento;
	private String pagamento;
	private Cliente Cliente;
	private List<PedidoItem> itens;

	public PedidoResponseDTO() {

	}

	public PedidoResponseDTO(Pedido pedido) {
		this.idPedido = pedido.getId();
		this.dataCompra = pedido.getDataCompra();
		this.dataEntrega = pedido.getDataEntrega();
		this.status = pedido.getStatus();
		this.valortotal = pedido.getValortotal();
		this.Cliente = pedido.getCliente();
		this.formaPagamento = pedido.getFormaPagamento();
		this.itens = pedido.getItens();
	}

	
	public String getPagamento() {
		return formaPagamento.getTipo();
	}

	public void setPagamento(String pagamento) {
		this.pagamento = formaPagamento.getTipo();
	}

	public List<PedidoItem> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItem> itens) {
		this.itens = itens;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
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

	public Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setTipoPagamento(FormaPagamento tipoPagamento) {
		this.formaPagamento = tipoPagamento;
	}

}
