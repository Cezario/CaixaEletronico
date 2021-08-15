package com.bancojompa.caixaeletronico.excessao;

public class SaldoInsuficienteException extends RuntimeException {

	private static final long serialVersionUID = -296145048873318099L;

	public SaldoInsuficienteException(String mensagem) {
		super(mensagem);
	}
	
}
