package banco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BancoTeste {
	
	private Banco banco;
	private ContaCorrente conta1, conta2;

	@BeforeEach
	public void test() {
		// Cria o banco e cria duas contas.
		banco = new Banco();
		conta1 = new ContaCorrente("123456", 100.0);
		conta2 = new ContaCorrente("456789", 50.0);
		
		//Regista as duas contas
		banco.registarConta(conta1);
		banco.registarConta(conta2);
	}
	
	@Test
	public void testObterSaldo() {		
		// Obtêm o saldo das duas contas
		assertEquals(1000, conta1.getSaldo(), "O saldo da conta com número '123456' deveria ser 1000€.");
		assertEquals(500, conta2.getSaldo(), "O saldo da conta com número '456789' deveria ser 500€.");
	}

}
