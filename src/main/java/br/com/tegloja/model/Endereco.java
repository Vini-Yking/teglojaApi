package br.com.tegloja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.tegloja.dto.EnderecoDTO;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long id;

	@Pattern(regexp = "^[0-9]{8}", message = "Cep precisa ter apenas números e 8 dígitos")
	@Column(nullable = false, unique = true)
	private String cep;

	private String logradouro;
	private String bairro;
	private String localidade;
	private String uf;

	public Endereco() {

	}

	public Endereco(Long id, String cep, String logradouro, String bairro, String cidade,
			String uf) {
		this.id = id;
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.localidade = cidade;
		this.uf = uf;

	}

	public Endereco(EnderecoDTO enderecoDTO) {
		this.id = enderecoDTO.getId();
		this.cep = enderecoDTO.getCep();
		this.logradouro = enderecoDTO.getLogradouro();
		this.bairro = enderecoDTO.getBairro();
		this.localidade = enderecoDTO.getCidade();
		this.uf = enderecoDTO.getUf();
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

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
// classe principal para retornar o endereco da API viacep