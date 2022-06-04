package br.com.tegloja.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

import br.com.tegloja.dto.ProdutoRequestDTO;
import br.com.tegloja.dto.ProdutoResponseDTO;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;

	@Column(name = "nm_produto")
	private String nomeProduto;
    
	@DecimalMin(value= "0.0", message= "Valor mínimo é zero")
	@Column(name = "valor_unit")
	private BigDecimal valorUnit;
    
	@Min(value= 0, message= "Quantidade mínima é zero")
	@Column(name = "qtd_estoque")
	private Integer quantidadeEstoq;
    
	
	@Column(name = "dt_ultima_alteracao")
	private LocalDate dataAlteracao;

	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	private List<PedidoItem> itens;

	@ManyToOne
	@JoinColumn(name = "id_categoria")
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

	public Produto(ProdutoRequestDTO produtoRequest) {
		this.categoria = produtoRequest.getCategoria();
		this.dataAlteracao = LocalDate.now();
		this.nomeProduto = produtoRequest.getNomeProduto();
		this.quantidadeEstoq = produtoRequest.getQuantidadeEstoq();
		this.valorUnit = produtoRequest.getValorUnit();
	}

	public Produto(ProdutoResponseDTO produtoResponseDTO) {
		this.categoria = produtoResponseDTO.getCategoria();
		this.dataAlteracao = produtoResponseDTO.getDataAlteracao();
		this.id = produtoResponseDTO.getIdProduto();
		this.nomeProduto = produtoResponseDTO.getNomeProduto();
		this.quantidadeEstoq = produtoResponseDTO.getQuantidadeEstoq();
		this.valorUnit = produtoResponseDTO.getValorUnit();
	}

	public List<PedidoItem> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItem> itens) {
		this.itens = itens;
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
