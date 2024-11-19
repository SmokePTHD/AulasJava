package Java;

public class Segunda {
	public static void main(String[] args) {
		int x = 5;
		// sysout + Ctrl+Space é shortcut no Eclipse para o System.out.println()
		System.out.println(x > 3 && x < 10); // retorna true porque 5 é maior que 3 e menir do que 10
		int x1 = 5;
		System.out.println(x1 > 3 || x1 < 4); // Retorna true porque uma das condições é true
		//Ctrl+I para corrigir indentação2
		int x2 = 5;
		System.out.println(!(x2 > 3 && x2 < 10)); // Retorna false porque ! (not) é usado para reverter o resultado
		// Métodos para strings (alguns exemplos)
		// length / comprimento 
		String txt = "abcdefghijklmnopqrstuvwxyz";
		System.out.println("O comprimento da string é: " + txt.length());
		// toUpperCase e toLoweCase / maiúscula / minúscula
		String txt1 = "Olá Mundo!";
		System.out.println(txt1.toUpperCase());
		System.out.println(txt1.toLowerCase());
		// indexOf / índice
		String txt2 = "Qual o índice (primeito posição) de cão?";
		System.out.println(txt2.indexOf("cão"));
		// Concatenação com +
		String nome = "João";
		String apelido = "Domingos";
		System.out.println(nome + " " + apelido);
		// Concatenação com concat
		String marca = "Renault";
		String modelo = "Clio";
		System.out.println(marca.concat(modelo));
		String y = "10";
		String w = "20";
		String z = y + w;
		System.out.println(z);
		// usar \ como caractere de escape
		String txt3 = "Modo de colocar \"aspas\" dentro de aspas.";
		System.out.println(txt3);
		String txt4 = "Nova\nLinha"; // Sequência de escape para new line
		System.out.println(txt4);
		String txt5 = "Retorno\rde carro"; // Sequência de escape para carrigage return; no tempo das máquinas de escrever elétricas digitais esta distinções era crucial
		System.out.println(txt5);
		String txt6 = "Aqui entra\tum tab"; // tabulação / avanço
		System.out.println(txt6);
		System.out.println(Math.max(5, 10)); // Valor Maximo
		System.out.println(Math.min(5, 10)); // Valor Minimo 
		System.out.println(Math.sqrt(64)); // Raiz Quadrada
		System.out.println(Math.abs(-4.7)); // Valor Absoluto
		int randomNum = (int)(Math.random() * 101); //Numero aleatorio 0 a 100
		System.out.println(randomNum);
		// instrução condicional if
		int x3 = 20;
		int y3 = 18;
		if (x3 > y3) {
			System.out.println("x3 é maior que y3");
		}
		// condicional else
		int hora = 20;
		if (hora < 20 ) {
			System.out.println("Bom Dia");
		} else {
			System.out.println("Boa Tarde");
		}
		
		int hora1 = 22;
		if (hora1 < 10) {
			System.out.println("Bom dia");
		} else if (hora1 < 18) {
			System.out.println("Boa Tarde");
		} else {
			System.out.println("Boa Noite");
		}
		int dia = 2;
		switch (dia) {
		
		case 1:
			System.out.println("Segunda");
			break;
			
		case 2:
			System.out.println("Terça");
			break;
			
		case 3:
			System.out.println("Quarta");
			break;
		}
		// loop while
		int i = 0;
		while (i < 5) {
			System.out.println(i);
			i++;
		}
		int i1 = 6;
		do {
			System.out.println(i1);
			i1++;
		} while (i1 < 5);
		
		for (int i2 = 0; i2 < 5; i2++) {
			System.out.println(i2);
		}
		for (int i3 = 0; i3 < 10; i3++) {
			if (i3 == 4) {
				break;
			}
			System.out.println(i3);
		}
		// Array
		String[] carros = {"Volvo", "BMW", "Ford", "Mazda"};
		System.out.println(carros[1] + ", " + carros[3]);
		
	}
}