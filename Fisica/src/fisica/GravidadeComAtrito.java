package fisica;

import javax.swing.*;
import java.awt.*;
import java.awt.RenderingHints;

public class GravidadeComAtrito extends JPanel {
	private static final long serialVersionUID = 1L;
	
	// Variaveis de estado da simulaçãoo
	private double y = 50;
	private double velocidadeY = 0;
	private double velocidadeX = 100; // Novo: Velocidade horizontal da bola (adicionada para simular movimento lateral)
	private final double gravidade = 500;
	private final double atrito = 0.95; // Novo: Fator de atrito (0 < atrito < 1)
	private long ultimoTempo; // Atualiza o tempo anterior
	private final int chao = 350;
	private final double amortecimento = 0.8;
	
	// Construtor da classe Gravidade
	public GravidadeComAtrito() {
		ultimoTempo = System.nanoTime();
		
		Timer timer = new Timer(16, e-> {
			long tempoAtual = System.nanoTime(); 
			double dt = (tempoAtual - ultimoTempo) / 1.0e9;
			
			ultimoTempo = tempoAtual;
			
			// 
			velocidadeY += gravidade * dt; //
			
			// Atualiza a posição da bola com base na velocidade
			y += velocidadeY * dt; // y = y0 + v * dt (equação do movimento uniforme acelarado)
			
			// Verifica se a bola atingiu o chão
			if (y > chao) { // Se a posição y da bola ultrapassar a posição do chão
				y = chao; // Corrige a posição da bola ultrapassar a posição do chão
				velocidadeY = -velocidadeY * amortecimento; // Inverte a velocidade e aplica amortecimento
				
				// Para a bola quando a velocidade for muito pequena (evita oscilações)
				if (Math.abs(velocidadeY) < 10) { // Se a Velocidade for menor que 10 pixels por segundo
					velocidadeY = 0; // Define a velocidade como zero
				}
			}
			
			// Novo: Aplica o atrito à velocidade horizontal (simula a perda de energia cinética ao rolar no chão)
			if (y == chao) {
				velocidadeX *= atrito; // Reduz a velocidade horizontal pelo fator de atrito
				
				// Para a bola quando a velocidade horizontal for muito pequena
				if (Math.abs(velocidadeX) < 0.1) { // Se a velocidade horizontal for menor que 0.1 pixels por segundo
					velocidadeX = 0; // Define a velocidade horizontal como zero
				}
			}
			
			repaint(); // Redesenha o painel (chama o método paintComponent)
		});
		timer.start(); // Inicia o timer
	}
	
	// Método responsável por desenhar os componentes da tela
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // Chama o método da superclasse parra garantir que o fundo seja desenhando corretamente
		
		Graphics2D g2d = (Graphics2D) g; // Converte o objeto Graphics para Graphics2D (permite usar recursos avançados)
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Ativa o anti-aliasing para suavisar as bordas
		
		// Desenha o fundo branco 
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, getWidth(), 10);
		
		// Desenha a bola (circulo azul)
		g2d.setColor(Color.BLUE);
		g2d.fillOval((int) Math.round(velocidadeX), (int) Math.round(y),20, 20); // Posição (150, y) com diâmetro de 20 pixels
		
		// Desenha o chão (retângulo preto)
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, chao + 20, getWidth(), 10);
		
		
	}
	
	// Método princinpal para executar o programa
	public static void main (String[] args) {
		JFrame frame = new JFrame("Gravidade Com Atrito"); // Alterado: Titulo da janela
		GravidadeComAtrito panel = new GravidadeComAtrito(); // Alterado: Cria uma instância do painel de animação com atrito
		frame.add(panel); // Adiciona o painel à janela
		frame.setSize(400, 420); // Define o tamanho da janela (400x420 pixels)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
		frame.setVisible(true); // Torna a janela visível	
	}
}
