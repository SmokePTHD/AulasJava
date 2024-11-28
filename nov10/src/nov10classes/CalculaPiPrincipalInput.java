package nov10classes;

import java.util.Scanner;

public class CalculaPiPrincipalInput {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CalculaPi calculaPi = new CalculaPi();
		
		System.out.println("");
		
		double resultado = calculaPi.CalcularPi(3);
		
		System.out.println("O resultado da area é " + resultado);
		
		scanner.close();
	}

}
