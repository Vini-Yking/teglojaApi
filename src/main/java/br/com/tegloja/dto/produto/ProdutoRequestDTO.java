package br.com.tegloja.dto.produto;

import java.math.BigDecimal;

public class ProdutoRequestDTO {

	private String nomeProduto;
	private BigDecimal valorUnit;
	private Integer quantidadeEstoq;

	public ProdutoRequestDTO() {
	}

	public ProdutoRequestDTO(String nomeProduto, BigDecimal valorUnit, Integer quantidadeEstoq) {
		super();
		this.nomeProduto = nomeProduto;
		this.valorUnit = valorUnit;
		this.quantidadeEstoq = quantidadeEstoq;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
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
