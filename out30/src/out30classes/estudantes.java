package out30classes;
 
class Estudante extends Pessoa {
	
	// Atributo privado, acessível apenas dentro da classe Estudante
	private int anoFormacao = 2018; //Ano em que o estudante se formou
	
	// Método main, ponto de estrada da aplicação
	public static void main(String[] args) {
		// Criação de uma instância da classe Estudante
		Estudante meuObj = new Estudante();
			// Impressão dos atributos da classe Estudante (herdados da classe Pessoa)
			System.out.println("Nome: " + meuObj.nome + "" + meuObj.apelido);
			System.out.println("Email " + meuObj.email);	
			System.out.println("idade: " + meuObj.idade);
			System.out.println("Ano de formação: " + meuObj.anoFormacao);	
	}
}