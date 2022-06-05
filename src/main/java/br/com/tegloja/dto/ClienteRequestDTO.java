package br.com.tegloja.dto;

import br.com.tegloja.model.Cliente;
import br.com.tegloja.model.Endereco;

public class ClienteRequestDTO {

	private String cpf;
	private String nome;
	private String email;
	private String cep;
	private Integer numeroEndereco;
	private Endereco endereco;
	

	public ClienteRequestDTO() {

	}
	
	public ClienteRequestDTO(Cliente cliente) {
		this.cpf = cliente.getCpf();
		this.cep = cliente.getCep();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.numeroEndereco = cliente.getNumeroEndereco();
		this.endereco = cliente.getEndereco();
	}
	
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Integer getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(Integer numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
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
