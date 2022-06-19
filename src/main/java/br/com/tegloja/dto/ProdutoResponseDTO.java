package br.com.tegloja.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.tegloja.model.Categoria;
import br.com.tegloja.model.Produto;

public class ProdutoResponseDTO {

	private Long idProduto;
	private Categoria categoria;
	private String nomeProduto;
	private BigDecimal valorUnitario;
	private Integer quantidadeEstoque;
	private LocalDate dataAlteracao;
	private String urlFoto;

	public ProdutoResponseDTO() {

	}

	public ProdutoResponseDTO(Produto produto) {
		this.dataAlteracao = produto.getDataAlteracao();
		this.categoria = produto.getCategoria();
		this.idProduto = produto.getId();
		this.nomeProduto = produto.getNomeProduto();
		this.quantidadeEstoque = produto.getQuantidadeEstoque();
		this.valorUnitario = produto.getValorUnitario();	
		this.urlFoto = produto.getUrlFoto();
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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

	public LocalDate getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDate dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

}
