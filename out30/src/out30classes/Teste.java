package out30classes;
 
public class Teste {
 
	public static void main(String[]args) {
		
		Exemplo exemplo = new Exemplo();
		
		// Acessando os modificadores de acesso
		System.out.println("Acesso ao público; " + exemplo.publico); // OK
		System.out.println("Acesso ao padrão; " + exemplo.padrao); // OK, mesmo pacote
		// System.out.println("Acesso ao privado; " + exemplo.privado); // Erro! (não acessivel)
		System.out.println("Acesso ao protegido; " + exemplo.protegido); // OK, mesmo pacote
	}
 
}
 
 