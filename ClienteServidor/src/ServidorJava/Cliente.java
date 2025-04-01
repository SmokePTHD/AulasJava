package ServidorJava;

import java.io.*;
import java.net.*;

public class Cliente {
	public static void main(String[] args) throws IOException {
		// Establece ligação com o servidor na porta 1234
		Socket socket = new Socket("localhost", 1234);
		
		// Configuração dos fluxos de entrada e saída
		PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		

		// Envia uma mensagem ao servidor
		output.println("Olá, servidor!");
		
		// Lê e exibe a resposta do servidor
		System.out.println("Resposta do servidor: " + input.readLine());
	}

}
