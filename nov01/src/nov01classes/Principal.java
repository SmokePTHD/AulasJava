package nov01classes;

public class Principal {
	public static void main(String[] args) {
		Pessoa pessoa = new Pesssoa();
		
		// Configurar os valores usando os setters
		pessoa.setNome("José");
		pessoa.setIdade(25);
		
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("Idade: " + pessoa.getIdade());
		
	}
}
 class Pessoa {
	 
	 // Variaveis privadas
	 private String nome;
	 private int idade;
	 
	 // Getter para nome
	 public String getNome() {
		 return nome;
	 }
	 
	 // Setter para nome
	 public void setNome() {
		 this.nome = nome;
	 }
	 
	 // Getter para idade
	 public int getIdade() {
		 return idade;
	 }
	 
	 // Setter para idade, com validação
	 public void setIdade(int idade) {
		 if (idade > 17) {
			 this.idade = idade;
		 } else {
			 System.out.println("Por favor, insira uma idade válida.");
		 }
	 }
	 
 }