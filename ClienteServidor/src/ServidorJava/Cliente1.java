package ServidorJava;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente1 {
    public static void main(String[] args) throws IOException {
        // Estabelece ligação com o servidor na porta 1234
        Socket socket = new Socket("localhost", 1234);
        
        // Configuração dos fluxos de entrada e saída
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        // Criação do Scanner para leitura do utilizador
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza uma mensagem para o servidor:");
        
        // Lê a mensagem do utilizador
        String mensagem = scanner.nextLine();
        
        // Apenas envia se a mensagem não estiver vazia
        if (!mensagem.isEmpty()) { 
            output.println(mensagem); // Envia a mensagem para o servidor
            System.out.println("Resposta do servidor: " + input.readLine()); // Aguarda e exibe a resposta
        } else {
            System.out.println("Mensagem vazia, nada foi enviado.");
        }
        
        // Fecha os recursos abertos para evitar vazamentos
        scanner.close();
        socket.close();
    }
}