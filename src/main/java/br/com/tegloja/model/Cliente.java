package br.com.tegloja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id;

	@CPF
	@Column(nullable = false,unique=true)
	private String cpf;

	@Column(nullable = false)
	private String cep;

	@Column(name = "nome_cliente", nullable = false)
	private String nome;

	@Column(nullable = false, unique=true)
	private String email;

	public Cliente() {
	}

	public Cliente(Long id, String cpf, String cep, String nome, String email) {
		this.id = id;
		this.cpf = cpf;
		this.cep = cep;
		this.nome = nome;
		this.email = email;
	}
	
	

	@Override //Usado para enviar email
	public String toString() {
		return "Cliente "+ nome + "\ncpf=" + cpf + "\ncep=" + cep + "\nemail=" + email + "";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
