package com.bancojompa.caixaeletronico.modelo;

import com.bancojompa.caixaeletronico.excessao.SaldoInsuficienteException;

public class TransacaoServico {

	public double depositar(double saldo, double deposito) {
		if (deposito <= 0) {
			throw new IllegalArgumentException("Valor de deposito incorreto!");
		}
		saldo += deposito;
		System.out.println("Depósito realizado no valor de R$: " + deposito);
		return saldo;
	}
	
	public double sacar(double saldo, double saque) throws SaldoInsuficienteException {
		if (saque < 0) {
			throw new IllegalArgumentException("Valor de saque Incorreto!!!");
		}
		double saldoSacado = saldo - saque;
		if (saldoSacado < 0) {
			throw new SaldoInsuficienteException("Saldo insuficiente!");
		}
		saldo -= saque;
		System.out.println("Saque realizado no valor de R$: " + saque + ", Por favor retire suas notas");
		return saldoSacado;
	}
}
