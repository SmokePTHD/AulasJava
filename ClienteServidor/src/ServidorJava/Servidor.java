package ServidorJava;

import java.io.*; // Importa classes para entrada e saída de dados (I/O)
import java.net.*; // Importa classes para trabalhar com redes.

public class Servidor {
	public static void main(String[] args) throws IOException {
		// Criação do servidor na porta 1234
		ServerSocket servidor = new ServerSocket(1234);
		System.out.println("Servidor em execução"); 
		
		while (true) {
			// Aceita a ligação de um cliente
			Socket cliente = servidor.accept();
			
			// Configuração dos fluxos de entrada e saída
			BufferedReader input = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			PrintWriter output = new PrintWriter(cliente.getOutputStream(), true);
			
			// Receba a mensagem do cliente
			String mensagem = input.readLine();
			System.out.println("Recebido: " + mensagem);
			
			// Envia resposta ao cliente
			output.println("Mensagem recebida: " + mensagem);
		}

	}

}
