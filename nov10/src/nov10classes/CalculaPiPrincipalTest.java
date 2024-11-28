package nov10classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculaPiPrincipalTest {

	@Test
	void testarCalcularPi() {
		CalculaPi calculaPi = new CalculaPi();
		
		double resultado = calculaPi.CalcularPi(3);
		
		assertEquals(28.2744, resultado, "Era suposto o resultado ser 28.2744");
	}

}