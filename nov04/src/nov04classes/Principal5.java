package nov04classes;

import java.util.Scanner;

public class Principal5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para ler a entrada do utilizador
		
		// Exemplo de compra à vista
		System.out.println("Digite o valor total para a compra à vista: ");
		int valorAVista = scanner.nextInt(); // Lê o valor total para uma compra à vista do utilizadpr
		Compra compraAVista = new Compra(valorAVista); // Cria um objeto Compra para o pagamento à vista
		System.out.println("\nCompra à Vista: ");
		System.out.println("Valor Total: " + compraAVista.getValorTotal()); // Exibe o valor da compra à vista
		System.out.println("Número de Prestações: " + compraAVista.getNumeroPrestacoes()); // Exibe o numero de prestações (1)
		System.out.println("Valora da Prestação: " + compraAVista.getValorPrestacao()); // Exibe o valor de cada prestação 
		
		System.out.println("\n-----------------------------\n");
		
		// Exemplo  de compra a prestação
		System.out.println("Digite p valor total para a compra a prestações: ");
		int valorTotalPrestacoes = scanner.nextInt(); // Lê o valor total da compra a prestações
		System.out.println("Digite o número de prestações desejado");
		int numeroPrestacoes = scanner.nextInt(); // Lê o número de prestações desejada
		
		// Cria um obejto de compra a prestações 
		Compra compraPrestacoes = new Compra(numeroPrestacoes, valorTotalPrestacoes); // Chama o construtor que calcula o valor total baseado nas prestações
		System.out.println("\nCompra a Prestações:");
		System.out.println("Valor Total: " + compraPrestacoes.getValorTotal()); // Exibe o valor total da compra a prestações
		System.out.println("Número de Prestações: " + compraPrestacoes.getNumeroPrestacoes()); // Exibe o número de prestações
		System.out.println("Valor da Prestação: " + compraPrestacoes.getValorPrestacao()); //Exive o valor de cada pretação
		
		scanner.close();
	}
}
