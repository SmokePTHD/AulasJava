package banco;

/**
 * Este é o formateo padrão para iniciar um comentário em Javadoc.
 * Classe ContaCorrete que representa uma conta bancária individual.
 * Esta classe armazena o número da conta e o saldo, e permite operações de crédito e débito no saldo.
 */

public class ContaCorrente {
	private String numeroConta;
	private double saldo;
	
	// Construtpr que define o n]umero da conta e saldo inicial
	public ContaCorrente(String numeroConta, double saldoInicial) {
		// Usa 'this' para referir-se ao atributo da classe e diferenciaá'lo do parâmetro do construtor
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}
	
	// Método para obter o número da conta
	public String getNumeroConta() {
		return numeroConta;
	}
	
	// Método para obter o slado atual
	public double getSaldo() {
		return saldo;
	}
	
	// Método para creditar um valor ao saldo da conta
	public void creditar(double valor) {
		saldo += valor; // Adiciona o valor ao saldo atual
	}
	
	// Método para debitar um valor do saldo da conta
	public void debitar(double valor) {
		// Verifica se há saldo suficiente antes de debitar
		if (valor <= saldo) {
			saldo -= valor;
		} else {
			System.out.println("Saldo insuficiente para esta operação.");
		}
	}
}
