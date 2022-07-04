package br.com.tegloja.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;

import br.com.tegloja.model.Cliente;

public class ClienteRequestDTO {

	@NotBlank(message = "Informe cpf")
	@CPF(message = "Insira um cpf válido")
	private String cpf;

	@NotBlank(message = "Informe nome")
	private String nome;

	@NotBlank(message = "Informe email")
	@Email(message = " Insira um e-mail válido")
	private String email;

	@NotBlank(message = "Informe cep")
	@Pattern(regexp = "^[0-9]{8}", message = "Cep precisa ter apenas números e 8 dígitos")
	private String cep;

	@NotNull(message = "Informe numeroEndereco, caso não houver informe 0")
	private Integer numeroEndereco;
	
	private String urlFoto;

	public ClienteRequestDTO() {

	}

	public ClienteRequestDTO(Cliente cliente) {
		this.cpf = cliente.getCpf();
		this.cep = cliente.getCep();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.numeroEndereco = cliente.getNumeroEndereco();
		this.urlFoto = cliente.getUrlFoto();
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
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
