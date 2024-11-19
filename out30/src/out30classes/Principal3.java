package out30classes;

public class Principal3 {

	// Metodo static
	static void meuMetodoStatic() {
		System.out.println("Metodos static podem ser chamados sem cirar objetos");
	}
	
	// Metodo public
	public static void meuMetodoPublic() {
		System.out.println("Metodo publicos tem de ser chamados criados objetos");
	}
	
	// Metodo main
	public static void main(String[] args) {
		meuMetodoStatic(); // Chama o metodo static
		
		Principal3 meuObj = new Principal3(); // Cria um objeto da classe Principal
		meuObj.meuMetodoPublic(); // Chama o metodo publico
	}
}
