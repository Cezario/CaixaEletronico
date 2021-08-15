package com.bancojompa.caixaeletronico.modelo;

public enum Transacao {

	SAQUE {
		@Override
		public void execute(TransacaoServico transacaoServico, Conta conta, double valor) {
			conta.setSaldo(transacaoServico.sacar(conta.getSaldo(), valor));
		}
	}, 
	DEPOSITO {
		@Override
		public void execute(TransacaoServico transacaoServico, Conta conta, double valor) {
			conta.setSaldo(transacaoServico.depositar(conta.getSaldo(), valor));
		}
	};
	
	public abstract void execute(TransacaoServico transacaoServico, Conta conta, double valor);
	
}
