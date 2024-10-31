package Java;

public class primeiro {
	public static void main(String[] args) {
		System.out.println("Olá Mundo");
		String nome = "Júlio";
		System.out.println(nome);
		final int menuNum = 15;
		// meuNum = 20; // Vai dar Erro
		int x = 5, y = 6, z = 50;
		System.out.println(x + y + z);
		int meuInt = 9;
		double meuDouble = meuInt;
		System.out.println(meuInt);
		System.out.println(meuDouble);
		double meuDouble1 = 9.78d;
		int meuInt1 = (int) meuDouble1;
		System.out.println(meuDouble1);
		System.out.println(meuInt1);
		
		int maxPont = 500;
		int utilPont = 423;
		// Calcular a percentagem da pontuação do utilizador em relação à pontuação máxima possível. Converte utilPont para float para assegurar resultado às décimas
		float percentagem = (float) utilPont / maxPont * 100.0f;
		System.out.println("A percentagem do utilizador é " + percentagem);
	}
}
