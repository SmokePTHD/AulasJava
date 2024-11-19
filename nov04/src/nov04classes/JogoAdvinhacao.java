package nov04classes;

import java.util.Random; // Importa a classe Random para gerar números aleatorios
import java.util.Scanner; // Importa a classe Scanner para capturar a entrado do utilizador

public class JogoAdvinhacao {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para leitura da entrada do utilizador
		Random random = new Random(); // Cria um objeto Random para gerar números aleatórios
		
		// O computador escolhe um número aleatorio entre 1 e 100
		int numeroSecreto = random.nextInt(100) + 1; // Gera um número aleatório de 0 a 99 e adiciona 1 para obter um número entre 1 e 100
		int tentativas = 0; // Inicializa o contador de tentativas
		int palpite = 0; // Inicializa a variável palpite
		
		System.out.println("Bem-Vindo ao jogo de advinhação!");
		System.out.println("Advinhe o número entre 1 a 100:");
		
		// Loop para permitir que o jogador continue a tentar até acertar
		while(palpite != numeroSecreto) {
			System.out.println("Insira o seu palpite; "); // Solicita ao jogador que insira um palpite
			
			// Lê o palpite do jogador e armazena-o na variável palpite
			palpite = scanner.nextInt(); // O metodo nextInt() captura um valor inteiro inserido pelo utilizador e atribui um valor a variavel palpite
			
			tentativas++; // Incrementa o contandor de tentativas
			
			// Verifica se o palpite do jogador é menor, maior ou igual ao número secreto
			if (palpite < numeroSecreto) {
				System.out.println("Muito baixo! Tente novamente.");
			} else if (palpite > numeroSecreto) {
				System.out.println("Muito alto! Tente novamente.");
			} else {
				System.out.println("Parabéns! Você acertou o número em " + tentativas + " tentativas.");
			}
		}
		
		scanner.close();
	}
}
