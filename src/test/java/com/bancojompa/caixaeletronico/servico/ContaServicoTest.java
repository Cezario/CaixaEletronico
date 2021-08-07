package com.bancojompa.caixaeletronico.servico;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.bancojompa.caixaeletronico.excessao.SaldoInsuficienteException;
import com.bancojompa.caixaeletronico.modelo.Conta;

public class ContaServicoTest {

	@Test
	public void quandoTiver100_Depositar100_DeveRetornar200() {
		Conta conta = new Conta();
		conta.setSaldo(100.0);
		
		ContaServico contaServico = new ContaServico();
		double saldo = contaServico.depositar(conta.getSaldo(), 100.0);
		
		Assertions.assertThat(saldo).isEqualTo(200.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveRetornarExcessaoQuandoOValorDepositoForNegativo() {
		ContaServico contaServico = new ContaServico();
		contaServico.depositar(100.0, -10.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveRetornarExcessaoQuandoValorForZero() {
		ContaServico contaServico = new ContaServico();
		contaServico.depositar(100.0, 0);
	}
	
	@Test
	public void quandoTiver100_Sacar100_DeveRetornarZero() throws SaldoInsuficienteException {
		Conta conta = new Conta();
		conta.setSaldo(100.0);
		
		ContaServico contaServico = new ContaServico();
		double saldo = contaServico.sacar(conta.getSaldo(), 100.0);
		
		Assertions.assertThat(saldo).isEqualTo(0);
	}
	
	@Test(expected = SaldoInsuficienteException.class)
	public void deveRetornarExcessaoQuandoValorForNegativo() throws SaldoInsuficienteException {
		ContaServico contaServico = new ContaServico();
		contaServico.sacar(100.0, 110.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveRetornarExcessaoQuandoValorDoSaqueForNegativo() throws SaldoInsuficienteException {
		ContaServico contaServico = new ContaServico();
		contaServico.sacar(100.0, -110.0);
	}
}
