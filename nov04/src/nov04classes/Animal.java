package nov04classes;

public class Animal {
	
	public void somAnimal() { // Método para produzir som do animal
		System.out.println("O animal fa um som");
	}
}

class Porco extends Animal { // Classe Porco que herda de Animal
	
	@Override
	public void somAnimal() { // Sobrescreve o método para som específico do porco
		System.out.println("O porco faz: Oink Oink");
	}
}

class Cao extends Animal { // Classe Cão que herda de Animal
	
	@Override
	public void somAnimal() {// Sobrescreve o método para som específico do Cão
		System.out.println("O porco faz: Au Au");
	}
}