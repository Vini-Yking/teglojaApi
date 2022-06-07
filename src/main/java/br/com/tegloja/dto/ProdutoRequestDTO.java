package br.com.tegloja.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ProdutoRequestDTO {

	@NotBlank(message = "Informe nomeProduto")
	private String nomeProduto;

	@NotNull(message = "Informe idCategoria")
	private Long idCategoria;

	@NotNull(message = "Informe valorUnitario")
	@DecimalMin(value = "0.0", message = "ValorUnitario deve ser um número positivo")
	private BigDecimal valorUnitario;

	@NotNull(message = "Informe quantidadeEstoque")
	@Positive(message = "quantidadeEstoque deve ser um número positivo")
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
