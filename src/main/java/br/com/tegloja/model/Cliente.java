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
	private String cpf;

	@Column(nullable = false)
	private String cep;

	@Column(name = "nm_cliente", nullable = false)
	private String nome;

	@Column(nullable = false)
	private String email;
	@Column(name = "teste_teste")
	private String teste;

	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cpf=" + cpf + ", cep=" + cep + ", nome=" + nome + ", email=" + email
				+ ", teste=" + teste + "]";
	}

	public Cliente(Long id, @CPF String cpf, String cep, String nome, String email, String teste) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.cep = cep;
		this.nome = nome;
		this.email = email;
		this.teste = teste;
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

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}

	

}
