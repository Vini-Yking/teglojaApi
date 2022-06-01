package br.com.tegloja.dto.produto;

import java.math.BigDecimal;

import br.com.tegloja.model.Categoria;

public class ProdutoRequestDTO {

	private String nomeProduto;
	private Categoria categoria;
	private BigDecimal valorUnit;
	private Integer quantidadeEstoq;

	public ProdutoRequestDTO() {
	}

	public ProdutoRequestDTO(String nomeProduto, Categoria categoria, BigDecimal valorUnit, Integer quantidadeEstoq) {
		super();
		this.nomeProduto = nomeProduto;
		this.categoria = categoria;
		this.valorUnit = valorUnit;
		this.quantidadeEstoq = quantidadeEstoq;
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

	public BigDecimal getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(BigDecimal valorUnit) {
		this.valorUnit = valorUnit;
	}

	public Integer getQuantidadeEstoq() {
		return quantidadeEstoq;
	}

	public void setQuantidadeEstoq(Integer quantidadeEstoq) {
		this.quantidadeEstoq = quantidadeEstoq;
	}

}
