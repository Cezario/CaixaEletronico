package com.bancojompa.caixaeletronico.servico;

import com.bancojompa.caixaeletronico.excessao.SaldoInsuficienteException;
import com.bancojompa.caixaeletronico.modelo.Conta;
import com.bancojompa.caixaeletronico.modelo.Transacao;
import com.bancojompa.caixaeletronico.modelo.TransacaoServico;

public class ContaServico {
	
	private TransacaoServico transacaoServico = new TransacaoServico(); 
	
	public void executarTransacao(Conta conta, double valor, Transacao transacao) throws SaldoInsuficienteException {
		if (transacao == null) {
			throw new IllegalArgumentException("Transacao não pode ser nula");
		}
		if (conta == null) {
			throw new IllegalArgumentException("Conta não pode ser nula");
		}
		transacao.execute(transacaoServico, conta, valor);
	}
	
}
