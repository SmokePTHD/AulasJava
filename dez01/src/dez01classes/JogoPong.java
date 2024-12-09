package dez01classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JogoPong extends JPanel implements ActionListener {
	// Definições de tamanho da tela, paddles e bola
	private static final int LARGURA = 800, ALTURA = 600;
	private static final int LARGURA_PADDLE = 20, ALTURA_PADDLE = 100;
	private static final int TAMANHO_BOLA = 20;
	
	// Falta coisas aqui
	
	// Posições das barras (paddles) dos jogaores
	private int jogador1Y = ALTURA / 2 - ALTURA_PADDLE /2;
	private int jogador2Y = ALTURA / 2 - ALTURA_PADDLE /2;
	
	
	// Velocidade de movimento das barras dos jogadores
	private int jogador1DY = 0, jogador2DY = 0;
	
	//Timer para atualização de tela (60FPS)
	private Timer timer;
	
	// Construtor da class PongGAme
	public JogoPong() {
		// Define o tamanho do painel e a cor de fundo
		setPreferredSize(new Dimension(LARGURA, ALTURA));
		setBackground(Color.BLACK);
		
		// Permite que o painel tenha foco para capturar eventos de teclado
		setFocusable(true);
		
		// Adicionar os listeners para as teclas de movimento
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Controle do jogador 1 com as teclas W e S
				if(e.getKeyCode() == KeyEvent.VK_W) {
					jogador1DY = -5; // Mover para cima
				} else if (e.getKeyCode() == KeyEvent.VK_S) {
					jogador1DY = 5; // Mover para baixo
				}
				
				// Controle do jogador 2 com as teclas de setas
				
			}
		});
	}
}
