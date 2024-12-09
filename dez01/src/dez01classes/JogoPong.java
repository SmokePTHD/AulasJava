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
}
