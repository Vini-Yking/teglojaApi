package br.com.tegloja.enums;

import java.util.Arrays;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.tegloja.handler.EnumValidationException;

public enum FormaPagamento {
	PARCELADO(1, "Cartao"), CREDITOAVISTA(2, "Credito a vista"), DEBIDO(3, "Debito"), PIX(4, "Pix"), BOLETO(5, "Boleto");

	private Integer codigo;
	private String tipo;

	@JsonCreator
	public static FormaPagamento verificaPagamento(Integer value) throws EnumValidationException{
		for (FormaPagamento pagamento : FormaPagamento.values()) {
			if (value.equals(pagamento.getCodigo())) {
				return pagamento;
			}
		}
		throw new EnumValidationException("Pagamento invalido");
	}
	
	public static FormaPagamento verificaPagamentoReal(Integer value) throws EnumValidationException {
        // @formatter:off
        Optional<FormaPagamento> pagamento = 
                Arrays
                .stream(FormaPagamento.values())
                .filter(x -> x.name().equals(value))
                .findFirst();
        // @formatter:on
        if (!pagamento.isEmpty())
            return pagamento.get();
        throw new EnumValidationException("Categoria inválida");
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
