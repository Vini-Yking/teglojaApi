package br.com.tegloja.dto;

import java.math.BigDecimal;

import br.com.tegloja.model.Categoria;

public class ProdutoRequestDTO {

	private String nomeProduto;
	private Categoria categoria;
	private BigDecimal valorUnitario;
	private Integer quantidadeEstoque;

	public ProdutoRequestDTO() {
	}

	public ProdutoRequestDTO(String nomeProduto, Categoria categoria, BigDecimal valorUnit, Integer quantidadeEstoq) {
		super();
		this.nomeProduto = nomeProduto;
		this.categoria = categoria;
		this.valorUnitario = valorUnit;
		this.quantidadeEstoque = quantidadeEstoq;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
