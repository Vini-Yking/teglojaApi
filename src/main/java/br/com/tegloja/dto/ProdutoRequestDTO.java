package br.com.tegloja.dto;

import java.math.BigDecimal;

import br.com.tegloja.model.Categoria;

public class ProdutoRequestDTO {

	private String nomeProduto;
	private Long idCategoria;
	private BigDecimal valorUnitario;
	private Integer quantidadeEstoque;

	public ProdutoRequestDTO() {
	}

	public ProdutoRequestDTO(String nomeProduto, Long idCategoria, BigDecimal valorUnitario,
			Integer quantidadeEstoque) {
		super();
		this.nomeProduto = nomeProduto;
		this.idCategoria = idCategoria;
		this.valorUnitario = valorUnitario;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnit) {
		this.valorUnitario = valorUnit;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoq) {
		this.quantidadeEstoque = quantidadeEstoq;
	}

}
