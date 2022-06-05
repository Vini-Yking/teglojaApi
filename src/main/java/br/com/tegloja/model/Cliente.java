package br.com.tegloja.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import br.com.tegloja.dto.ClienteRequestDTO;
import br.com.tegloja.dto.ClienteResponseDTO;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id;

	@CPF(message = "Insira um cpf válido")
	@Column(nullable = false)
	private String cpf;

	@Pattern(regexp = "^[0-9]{8}", message = "precisam ser oito numeros")
	@Size(min = 8, max = 8, message = "Cep precisa ter oito Digitos")
	@Column(nullable = false)
	private String cep;

	@NotNull(message = "Numero endereço precisa ser preenchido caso não haja numero, informe 0")
	@Column(name = "endereco_numero", nullable = false)
	private Integer numeroEndereco;

	@NotNull(message = "Deve inserir um nome")
	@Column(name = "nome_cliente", nullable = false)
	private String nome;

	@Email(message = " Insira um e-mail válido")
	@Column(nullable = false)
	private String email;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	public Cliente() {
	}

	public Cliente(ClienteRequestDTO clienteRequest) {
		this.cep = clienteRequest.getCep();
		this.cpf = clienteRequest.getCpf();
		this.email = clienteRequest.getEmail();
		this.nome = clienteRequest.getNome();
		this.numeroEndereco = clienteRequest.getNumeroEndereco();
	}

	public Cliente(Long id, String cpf, String cep, String nome, String email, Integer numeroEndereco) {
		this.id = id;
		this.cpf = cpf;
		this.cep = cep;
		this.nome = nome;
		this.email = email;
		this.numeroEndereco = numeroEndereco;
	}

	public Cliente(ClienteResponseDTO clienteResponse) {
		this.cep = clienteResponse.getCep();
		this.cpf = clienteResponse.getCpf();
		this.email = clienteResponse.getEmail();
		this.id = clienteResponse.getId();
		this.nome = clienteResponse.getNome();
		this.numeroEndereco = clienteResponse.getNumeroEndereco();
	}

	@Override // Usado para enviar email
	public String toString() {
		return "Cliente " + nome + "\ncpf=" + cpf + "\ncep=" + cep + "\nemail=" + email + "";
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
