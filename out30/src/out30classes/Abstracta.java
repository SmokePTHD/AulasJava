package out30classes;
//a classe nao pode ser utilizada para criar objetos (para aceder a uma classe abstrata, tem de ser herdada de outra classe)
//classe principal é Segunda
abstract class Abstracta {
	public String nome = "José";
	public String apelido = "Sousa";
	public String email = "josesousa@epb.com";
	public int idade = 17;
	
	public abstract void estudar(); //método abstract
 
}
 
//subclass (herda de Abstracta)
class Estudante1 extends Abstracta {
	public int anoFormacao = 2018;
	
	public void estudar() {
		System.out.println("Estudar todo o dia.");
	}
}