package br.com.tegloja.model;

import lombok.Getter;

@Getter
public class Endereco {
	
	private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
}
//classe principal para retornar o endereco da API viacep