package com.bancojompa.caixaeletronico;

import java.util.Scanner;

import com.bancojompa.caixaeletronico.excessao.SaldoInsuficienteException;
import com.bancojompa.caixaeletronico.modelo.Conta;
import com.bancojompa.caixaeletronico.modelo.Transacao;
import com.bancojompa.caixaeletronico.servico.ContaServico;

public class BancojompaCaixaeletronicoApplication {
	static Scanner entrada = new Scanner(System.in);
	static Conta conta = new Conta();
	static ContaServico contaServico = new ContaServico();
	
	public static void main(String[] args) {
		int entradaMenu = -1;
		
		while (entradaMenu != 4) {
			menuInicial();
			menuOpcao(entradaMenu = entrada.nextInt());
		}
		
	}

	public static void menuInicial() {
		System.out.println("---------------BancoJompa---------------");
		System.out.println();
		System.out.println("------------Caixa Eletrônico------------");
		System.out.println();
		System.out.println("----------Seja Bem Vindo ao BJ----------");
		System.out.println();
		System.out.println("----Selecione uma das opções abaixo:----");
		System.out.println();
		System.out.println(" 1 -- Depósito em conta");
		System.out.println(" 2 -- Saque na Conta");
		System.out.println(" 3 -- Saldo da Conta");
		System.out.println(" 4 -- Sair");

	}

	public static void menuOpcao(int entradaMenu) {
		double valor;
		
		contaServico = new ContaServico();
	
		switch (entradaMenu) {
		case 1:
			System.out.println("Insira o valor do depósito: ");
			valor = entrada.nextDouble();
			try {
				contaServico.executarTransacao(conta, valor, Transacao.DEPOSITO);
			} catch (IllegalArgumentException | SaldoInsuficienteException e) {
				System.out.println("Operação ilegal: " + e.getMessage());
			}
			break;
		case 2:
			System.out.println("Informe o valor do saque: ");
			valor = entrada.nextDouble();
			try {
				contaServico.executarTransacao(conta, valor, Transacao.SAQUE);
			} catch (SaldoInsuficienteException e) {
				System.out.println("Operação ilegal: " + e.getMessage());
			}
			break;
		case 3:
			System.out.println("Saldo atual: " + conta.getSaldo());
			break;
		case 4:
			System.out.println("Operação finalizada, Obrigado!");
			break;
		default:
			System.out.println("Opção inválida!!!");

		}
	
	}

}