package br.com.tegloja.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.tegloja.handler.EnumValidationException;

public enum StatusCompra {
	FINALIZADO, NAO_FINALIZADO;

	@JsonCreator
	public static StatusCompra verificaStatus(String value) throws EnumValidationException {
		for (StatusCompra statusCompra : StatusCompra.values()) {
			if (value.equals(statusCompra.name())) {
				return statusCompra;
			}
		}

		throw new EnumValidationException("Status inválido");
	}
}