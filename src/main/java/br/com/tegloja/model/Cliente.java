package br.com.tegloja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id;
	
	@CPF
	private String cpf;
	
	@Column(nullable=false)
	private String cep;
	
	@Column(name="nm_cliente",nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String email;
	@Column(name="teste_teste")
	private String teste;
}
