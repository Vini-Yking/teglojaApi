package br.com.tegloja.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;

	@Column(name = "nm_produto")
	private String nomeProduto;
	@Column(name = "valor_unit")
	private BigDecimal valorUnit;
	@Column(name = "qtd_estoque")
	private Integer quantidadeEstoq;
	@Column(name = "dt_ultima_alteracao")
	private LocalDate dataAlteracao;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Categoria categoria;

	public Produto() {

	}

	public Produto(Long id, String nomeProduto, BigDecimal valorUnit, Integer quantidadeEstoq, LocalDate dataAlteracao,
			Categoria categoria) {
		super();
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.valorUnit = valorUnit;
		this.quantidadeEstoq = quantidadeEstoq;
		this.dataAlteracao = dataAlteracao;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
