package com.bancojompa.caixaeletronico.servico;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.bancojompa.caixaeletronico.excessao.SaldoInsuficienteException;
import com.bancojompa.caixaeletronico.modelo.Conta;
import com.bancojompa.caixaeletronico.modelo.Transacao;

public class ContaServicoTest {

	@Test
	public void quandoTiver100_Depositar100_DeveRetornar200() throws SaldoInsuficienteException {
		Conta conta = new Conta();
		conta.setSaldo(100.0);
		
		ContaServico contaServico = new ContaServico();
		contaServico.executarTransacao(conta, 100.0, Transacao.DEPOSITO);
		
		Assertions.assertThat(conta.getSaldo()).isEqualTo(200.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveRetornarExcessaoQuandoOValorDepositoForNegativo() throws SaldoInsuficienteException {
		ContaServico contaServico = new ContaServico();
		Conta conta = new Conta();
		contaServico.executarTransacao(conta, -10.0, Transacao.SAQUE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveRetornarExcessaoQuandoValorForZeroAoRealizarDeposito() throws SaldoInsuficienteException {
		ContaServico contaServico = new ContaServico();
		contaServico.executarTransacao(new Conta(), 0, Transacao.DEPOSITO);
	}
	
	@Test
	public void quandoTiver100_Sacar100_DeveRetornarZero() throws SaldoInsuficienteException {
		Conta conta = new Conta();
		ContaServico contaServico = new ContaServico();
		conta.setSaldo(100.0);
		
		contaServico.executarTransacao(conta, 100.0, Transacao.SAQUE);

		Assertions.assertThat(conta.getSaldo()).isEqualTo(0);
	}
	
	@Test(expected = SaldoInsuficienteException.class)
	public void deveRetornarExcessaoQuandoValorForNegativoAoRealizarSaque() throws SaldoInsuficienteException {
		ContaServico contaServico = new ContaServico();
		Conta conta = new Conta();
		conta.setSaldo(100.0);
		contaServico.executarTransacao(conta, 110.0, Transacao.SAQUE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveRetornarExcessaoQuandoValorDoSaqueForNegativo() throws SaldoInsuficienteException {
		ContaServico contaServico = new ContaServico();
		Conta conta = new Conta();
		contaServico.executarTransacao(conta, -1.0, Transacao.SAQUE);
	}
}
