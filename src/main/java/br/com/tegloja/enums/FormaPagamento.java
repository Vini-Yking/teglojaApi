package br.com.tegloja.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum FormaPagamento {
	PARCELADO(1, "Cartao"), CREDITOAVISTA(2, "Credito a vista"), DEBIDO(3, "Debito"), PIX(4, "Pix"),
	BOLETO(5, "Boleto");

	private Integer codigo;
	private String tipo;

	@JsonCreator
	public static FormaPagamento verificaCombustivel(Integer value) throws EnumValidationException {
		for (FormaPagamento pagamento : FormaPagamento.values()) {
			if (value.equals(pagamento.getCodigo())) {
				return pagamento;
			}
		}
		throw new EnumValidationException("Pagamento inválido");
	}

	private FormaPagamento(Integer codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return tipo;
	}

}
