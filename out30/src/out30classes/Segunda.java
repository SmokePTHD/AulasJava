package out30classes;
 
//Classe principal
class Segunda {
	public static void main(String[]args) {
		//Cria um objeto da classe Estudante1
		Estudante1 meuObj = new Estudante1();
		
		System.out.println("Nome: " + meuObj.nome + " " + meuObj.apelido);
		System.out.println("Email: " + meuObj.email);
		System.out.println("Idade: " + meuObj.idade);
		System.out.println("Ano de formação: " + meuObj.anoFormacao);
		
		meuObj.estudar(); //Chama método abstracto
	}
}