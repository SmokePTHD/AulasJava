package nov10classes;

//Com o método assertEquals se os valores não forem iguais, o teste falhará e será lançada uma mensagem
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegistoPontosTest {
	private RegistoPontos registoPontos;
	private Utilizador utilizador;
	private CalculadoraBonus calculadoraBonus;
	
	@BeforeEach
	public void setup() {
		//Inicializa os objetos antes de cada teste
		calculadoraBonus = new CalculadoraBonus();
		registoPontos = new RegistoPontos(calculadoraBonus);
		utilizador = new Utilizador();
		utilizador.setNome("João");
		utilizador.setPontos(0);
		utilizador.setVip(false);
	}
	
	@Test
	public void testFazerComentarioUtilizadorNormal() {
		//Testa se fazer um comentário atribui corretamente os pontos a um utilizador não VIP
		registoPontos.fazerComentario(utilizador);
		assertEquals(3, utilizador.getPontos(), "O utilizador normal deveria ter 3 pontos após fazer um comentário.");
	}
	
	@Test
	public void testCriarTopicoUtilizadorNormal() {
		//Testa se criar um tópico atribui corretamente os pontos a um utilizador não VIP
		registoPontos.criarTopico(utilizador);
		assertEquals(5, utilizador.getPontos(), "O utilizador normal deveria ter 5 pontos após dar um tópico.");
	}
	
	public void testDarLikeUtilizadorNormal() {
		//Testa se dar um 'like' atribui corretamente os pontos a um utilizador não VIP
		registoPontos.darLike(utilizador);
		assertEquals(1, utilizador.getPontos(), "O utilizador normal deveria ter 1 ponto após dar um 'like'.");
	}
	
	@Test
	public void testFazerComentarioUtilizadorVip() {
		//Testa se fazer um comentário atribui corretamente os pontos a um utilizador VIP
		utilizador.setVip(true);
		registoPontos.fazerComentario(utilizador);
		assertEquals(15, utilizador.getPontos(), "O utilizador normal deveria ter 15 pontos após fazer um comentário.");
	}
	
	@Test
	public void testCriarTopicoUtilizadorVip() {
		//Testa se criar um tópico atribui corretamente os pontos a um utilizador VIP
		utilizador.setVip(true);
		registoPontos.criarTopico(utilizador);
		assertEquals(25, utilizador.getPontos(), "O utilizador normal deveria ter 25 pontos após dar um tópico.");
	}
	
	@Test
	public void testDarLikeUtilizadorVip() {
		//Testa se dar um 'like' atribui corretamente os pontos a um utilizador VIP
		utilizador.setVip(true);
		registoPontos.darLike(utilizador);
		assertEquals(5, utilizador.getPontos(), "O utilizador normal deveria ter 1 ponto após dar um 'like'.");
	}
}
