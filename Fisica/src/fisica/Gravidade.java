package fisica;

import javax.swing.*;
import java.awt.*;
import java.awt.RenderingHints;

public class Gravidade extends JPanel {
	private static final long serialVersionUID = 1L;
	
	// Variaveis de estado da simulaçãoo
	private double y = 50;
	private double velocidade = 0;
	private long ultimoTempo;
	private final double gravidade = 500;
	private final int chao = 350;
	private final double amortecimento = 0.8;
	
	// Construtor da classe Gravidade
	public Gravidade() {
		ultimoTempo = System.nanoTime();
		
		Timer timer = new Timer(26, e-> {
			long tempoAtual = System.nanoTime(); 
			double dt = (tempoAtual - ultimoTempo) / 1.0e9;
			
			ultimoTempo = tempoAtual;
			
			// 
			velocidade += gravidade * dt; //
			
			// Atualiza a posição da bola com base na velocidade
			y += velocidade * dt; // y = y0 + v * dt (equação do movimento uniforme acelarado)
			
			// Verifica se a bola atingiu o chão
			if (y > chao) { // Se a posição y da bola ultrapassar a posição do chão
				y = chao; // Corrige a posição da bola ultrapassar a posição do chão
				velocidade = -velocidade * amortecimento; // Inverte a velocidade e aplica amortecimento
				
				// Para a bola quando a velocidade for muito pequena (evita oscilações)
				if (Math.abs(velocidade) < 10) { // Se a Velocidade for menor que 10 pixels por segundo
					velocidade = 0; // Define a velocidade como zero
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
		g2d.fillOval(150, (int) Math.round(y), 20, 20); // Posição (150, y) com diâmetro de 20 pixels
		
		
	}
	
	// Método princinpal para executar o programa
	public static void main (String[] args) {
		JFrame frame = new JFrame("Gravidade"); // Criar uma janela com o título "Gravidade"
		Gravidade panel = new Gravidade(); // Cria uma instância do painel de animação
		frame.add(panel); // Adiciona o painel à janela
		frame.setSize(400, 400); // Define o tamanho da janela (400x400 pixels)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
		frame.setVisible(true); // Torna a janela visível	
	}
}
