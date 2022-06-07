package br.com.tegloja.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ClientePutRequestDTO {

	@NotNull(message = "Numero endereço precisa ser preenchido caso não haja numero, informe 0")
	private Integer numeroEndereco;

	@NotNull(message = "Deve inserir um nome")
	private String nome;

	@Pattern(regexp = "^[0-9]{8}", message = "Cep precisa ter apenas números e 8 dígitos")
	private String cep;

	public ClientePutRequestDTO() {

	}

	public ClientePutRequestDTO(Integer numeroEndereco, String nome, String cep) {
		super();
		this.numeroEndereco = numeroEndereco;
		this.nome = nome;
		this.cep = cep;
	}

	public Integer getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(Integer numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
