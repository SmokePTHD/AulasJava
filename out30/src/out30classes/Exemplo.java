package out30classes;
 
class Exemplo {
		// esta classe vai ser chamada pela classe Teste
		public int publico;	   //Acessivel de qualquer lugar
		int padrao;				//Acessivel apenas dentro do mesmo pacote (default)
		private int privado;	// Acessivel apenas dentro da própria classe
		protected int protegido;	//Acessivel dentro da mesma classe, pacotes e subclasses
		
		public Exemplo() {
			publico = 1;
			padrao = 2;
			privado = 3;
			protegido = 4;
			
	}
}
 