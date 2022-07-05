package br.com.tegloja.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class ProdutoRequestDTO {

	@NotBlank(message = "Informe nomeProduto")
	private String nomeProduto;

	@NotNull(message = "Informe idCategoria")
	private Long idCategoria;

	@NotNull(message = "Informe valorUnitario")
	@Digits(integer = 6, fraction = 2, message = "Máximo de 2 casas decimais para valorUnitario")
	@PositiveOrZero(message = "valorUnitario deve ser um número positivo ou 0")
	private BigDecimal valorUnitario;

	@NotNull(message = "Informe quantidadeEstoque")
	@PositiveOrZero(message = "quantidadeEstoque deve ser um número positivo ou 0")
	private Integer quantidadeEstoque;

	private String urlFoto;
	
	public ProdutoRequestDTO() {
	}

	public ProdutoRequestDTO(String nomeProduto, Long idCategoria, BigDecimal valorUnitario,
			Integer quantidadeEstoque, String urlFoto) {
		super();
		this.nomeProduto = nomeProduto;
		this.idCategoria = idCategoria;
		this.valorUnitario = valorUnitario;
		this.quantidadeEstoque = quantidadeEstoque;
		this.urlFoto = urlFoto;
	}
	
	

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
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
