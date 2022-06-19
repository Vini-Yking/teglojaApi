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
import javax.validation.constraints.DecimalMin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.tegloja.dto.ProdutoRequestDTO;
import br.com.tegloja.dto.ProdutoResponseDTO;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;

	@Column(name = "nome_produto")
	private String nomeProduto;

	@DecimalMin(value = "0.0", message = "ValorUnitario mínimo é zero")
	@Column(name = "valor_unitario")
	private BigDecimal valorUnitario;

	@Column(name = "quantidade_estoque")
	private Integer quantidadeEstoque;

	@Column(name = "data_ultima_alteracao")
	private LocalDate dataAlteracao;

	@Column(name= "url")
	private String urlFoto;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	public Produto() {

	}

	public Produto(Long id, String nomeProduto, BigDecimal valorUnit, Integer quantidadeEstoq, LocalDate dataAlteracao, String urlFoto,
			Categoria categoria) {
		super();
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.valorUnitario = valorUnit;
		this.quantidadeEstoque = quantidadeEstoq;
		this.dataAlteracao = dataAlteracao;
		this.urlFoto = urlFoto;
		this.categoria = categoria;
	}

	public Produto(ProdutoRequestDTO produtoRequest) {
		this.dataAlteracao = LocalDate.now();
		this.nomeProduto = produtoRequest.getNomeProduto();
		this.quantidadeEstoque = produtoRequest.getQuantidadeEstoque();
		this.valorUnitario = produtoRequest.getValorUnitario();
	}

	public Produto(ProdutoResponseDTO produtoResponseDTO) {
		this.categoria = produtoResponseDTO.getCategoria();
		this.dataAlteracao = produtoResponseDTO.getDataAlteracao();
		this.id = produtoResponseDTO.getIdProduto();
		this.nomeProduto = produtoResponseDTO.getNomeProduto();
		this.quantidadeEstoque = produtoResponseDTO.getQuantidadeEstoque();
		this.valorUnitario = produtoResponseDTO.getValorUnitario();
		
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

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnit(BigDecimal valorUnit) {
		this.valorUnitario = valorUnit;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoq(Integer quantidadeEstoq) {
		this.quantidadeEstoque = quantidadeEstoq;
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

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

}
