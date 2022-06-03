package br.com.tegloja.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.tegloja.model.Categoria;
import br.com.tegloja.model.Foto;
import br.com.tegloja.model.Produto;

public class ProdutoResponseDTO {

	private Long idProduto;
	private Categoria categoria;
	private String nomeProduto;
	private BigDecimal valorUnit;
	private Integer quantidadeEstoq;
	private LocalDate dataAlteracao;

	public ProdutoResponseDTO() {

	}

	public ProdutoResponseDTO(Produto produto,String urlFoto) {
		this.dataAlteracao = produto.getDataAlteracao();
		this.categoria = produto.getCategoria();
		this.idProduto = produto.getId();
		this.nomeProduto = produto.getNomeProduto();
		this.quantidadeEstoq = produto.getQuantidadeEstoq();
		this.valorUnit = produto.getValorUnit();	
	}
	
	public ProdutoResponseDTO(Produto produto) {
		this.dataAlteracao = produto.getDataAlteracao();
		this.categoria = produto.getCategoria();
		this.idProduto = produto.getId();
		this.nomeProduto = produto.getNomeProduto();
		this.quantidadeEstoq = produto.getQuantidadeEstoq();
		this.valorUnit = produto.getValorUnit();		
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
