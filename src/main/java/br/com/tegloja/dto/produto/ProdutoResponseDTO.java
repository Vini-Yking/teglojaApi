package br.com.tegloja.dto.produto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoResponseDTO {

	private Long idProduto;
	private String nomeProduto;
	private BigDecimal valorUnit;
	private Integer quantidadeEstoq;
	private LocalDate dataAlteracao;

	public ProdutoResponseDTO(Long idProduto, String nomeProduto, BigDecimal valorUnit, Integer quantidadeEstoq,
			LocalDate dataAlteracao) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.valorUnit = valorUnit;
		this.quantidadeEstoq = quantidadeEstoq;
		this.dataAlteracao = dataAlteracao;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
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

	public LocalDate getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDate dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

}
