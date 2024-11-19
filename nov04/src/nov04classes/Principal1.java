package nov04classes;

public class Principal1 { // Classe principal1 que contém o método main
	
	public static void main(String[] args) {
		
		Animal meuAnimal = new Animal();	// Cria um objeto Animal
		Animal meuPorco = new Porco();		// Cria um objeto Porco
		Animal meuCao = new Cao();			// Cria um objeto Cão
		
		meuAnimal.somAnimal();	// Chama o método somAnimal para o objeto Animal
		meuPorco.somAnimal();	// Chama o método somAnimal para o objeto Porco
		meuCao.somAnimal();		// Chama o método somAnimal para o objeto Cão
	}

}
