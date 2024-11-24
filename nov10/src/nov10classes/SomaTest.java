package nov10classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

// Classe que contém os testes unitários para a classe Soma.
class SomaTest {

	// Método de teste para o método somar da classe Soma.
	@Test
	void test() {
		// Criação de uma instância da classe Soma, que contém o método a ser testado.
		Soma soma = new Soma();
		
		// Chamada ao método simar com os valores 2 e 3, armazenando o resultado.
		int resultado = soma.somar(2, 3);
		
		// Verificação se o resultado do método somar é igual ao valor esperado (5).
		// A mensagem é opcional e ajuda a identificar o erro em caso de falha do teste
		assertEquals(5, resultado, "A soma de 2 e 3 deve ser 5");
	}

}