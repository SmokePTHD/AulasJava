package nov04classes;

import java.util.Scanner; // Importa a classe Scanner (permite input do utilizador) do package java.util. Para importar todo o package seria import java.util

public class Importar {
	public static void main(String[] args) {
		Scanner meuObj = new Scanner(System.in);
		String nome;
		
		System.out.println("Escreva o nome e pressione Enter");
		nome = meuObj.nextLine();
		
		System.out.println("Bom dia " + nome);
		
		meuObj.close();// Fecha o objeto Scanner não é obrigatorio mas é recomendável quando não for mais utilizado
	}
}
