package br.com.tegloja.dto;

public class ClientePutRequestDTO {

	private Integer numeroEndereco;
	private String nome;
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
