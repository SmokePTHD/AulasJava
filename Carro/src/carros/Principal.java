package carros;

public class Principal {
	public static void main(String[] args) {
		// Criar objetos da classe Carro; o construtor tem o mesmo nome da classe
		Carros c1 = new Carros("Corsa", 10, 0);
		Carros c2 = new Carros("Clio", 15, 0);
		Carros c3 = new Carros("Corsa", 5, 0); // É outro objeto, com classe Carro
		
		c1.acelerar(); // Chamada ao método acelarar() da classe Carros
		c1.acelerar();
		c1.acelerar();
		c1.travar(); // chamada ao método travar() da classe Carros
		
		c2.acelerar();
		c2.acelerar();
		
		c3.acelerar();
		
		//Imprime as informações dos carros
		c1.imprimir();
		c2.imprimir();
		System.out.println("Verifique que o valor de c3 não é alertado por c1, apesar de ambos serem Corsa");
		c3.imprimir();
	}
}
