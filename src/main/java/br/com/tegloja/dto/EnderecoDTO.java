package br.com.tegloja.dto;

import br.com.tegloja.model.Endereco;

public class EnderecoDTO {
	
	private Long id;
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;

	public EnderecoDTO() {

	}

	public EnderecoDTO(Endereco endereco) {
		this.id = endereco.getId();
		this.cep = endereco.getCep();
		this.logradouro = endereco.getLogradouro();
		this.complemento = endereco.getComplemento();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getLocalidade();
		this.uf = endereco.getUf();
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String localidade) {
		this.cidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
