package br.com.tegloja.dto;

public class ClienteRequestDTO {

	private String cpf;
	private String cep;
	private Integer numeroEndereco;
	private String nome;
	private String email;
	

	public ClienteRequestDTO() {

	}

	public ClienteRequestDTO(String cpf, String cep, String nome, String email, Integer numeroEndereco) {
		super();
		this.cpf = cpf;
		this.cep = cep;
		this.nome = nome;
		this.email = email;
		this.numeroEndereco = numeroEndereco;
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
