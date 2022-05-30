package br.com.tegloja.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;
	
	@Column(name="nm_produto")
	private String nomeProduto;
	@Column(name="valor_unit")
	private BigDecimal valorUnit;
	@Column(name="qtd_estoque")
	private Integer quantidadeEstoq;
	@Column(name="dt_ultima_alteracao")
	private LocalDate dataAlteracao;
	
//	private Categoria categoria;
}
