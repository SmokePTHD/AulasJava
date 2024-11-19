package banco;

/**
 * Classe Banco que representa um banco e gere múltiplas contas ativas.
 * Permite registar noavas conta, apresentar números das contas ativas
 * e obter o saldo total de todas as contas. 
 */

import java.util.ArrayList;

public class Banco {
	// Cria um ArrayList para armazenar contas ativas
	private ArrayList<ContaCorrente> contasAtivas = new ArrayList<>();
	
	// Método para registar uma nova conta no banco
	public void registarConta(ContaCorrente conta) {
		contasAtivas.add(conta); // Adiciona a conta ao arrayList contas Ativas
	}
	
	// Método para apresentar os números das contas ativas
	public void apresentarNumerosContas() {
		System.out.println("Contas ativas: ");
		
		// 'for-each' para iterar por todas as contas em contasAtivas
		for (ContaCorrente conta : contasAtivas) {
			// A cada iteração 'conta' é um objeto ContaCorrente na lista contasAtivas
			System.out.println("Conta: " + conta.getNumeroConta());
		}
	}
	
	// Método para obter o saldo total de todas as contas no banco
	public double obterSaldoTotal() {
		double saldoTotal = 0;
		
		// Itera por todas as contas no ArrayList e soma os saldos
		for (ContaCorrente conta : contasAtivas) {
			saldoTotal += conta.getSaldo();
		}
		return saldoTotal;
	}
}
