package carros;

public class Carros {
	int potencia; // Potência do carro
	int velocidade; // velocidade atual do carro
	final String nome; // Nome do carro
	
	// Contstrutor
	public Carros(String nome, int potencia, int velocidade ) {
		this.nome = nome; // 'this.nome' refere-se ao atributo da instância da classe, enquanto 'nome' é o parâmetro do construtor
		this.potencia = potencia;
		this.velocidade = velocidade; // Inicializa a Veloxidade em 0
	}
	
	void acelerar() { // Aumentar a velocidade do carro
		velocidade += potencia;
	}
	
	void travar() { // Reduz a velocidade do carro pela metade
		velocidade = velocidade / 2;
	}
	
	int getVelocidade() { // Retorna a velocidade atual do carro
		return velocidade;
	}
	
	void imprimir() {
		System.out.println("O carro " + nome + " está à velocidade de " + getVelocidade() + " km/h");
	}
}
