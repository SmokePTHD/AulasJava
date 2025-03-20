package fisica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ForcaAceleracao extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	
	// Variáveis de estado da simulação
	private double x = 50; // Posição horizontal inicial da bola
	private double velocidadeX = 0; // Velocidade horizontal da bola
	private final double massa = 10; // Massa da bola (kg)
	private final double forcaAplicada = 50; // Força aplicada (N)
	private final double atrito = 0.98; // Fator de atrito (0 < atrito < 1)
	private boolean forcaAtiva = false; // Indica se a força está sendo aplicada
	private long ultimoTempo; // Armazena o tempo da última atualização
	
	public ForcaAceleracao() {
		ultimoTempo = System.nanoTime(); // Inicializa o tempo de referência para o cálculo do delta time (dt)
		
		// Timer para atualizar a animação a cada 16ms (aproximadamente 60 FPS)
		Timer timer = new Timer(16, e-> {
			long tempoAtual = System.nanoTime(); // Obtém o tempo atual em nanossegundos
			double dt = (tempoAtual - ultimoTempo) / 1.0e9; // Calcula o delta time (tempo decorrido desde a última atualização)
			
			ultimoTempo = tempoAtual; // Atualiza o tempo de referência para a próxima iteração
			
			// Calcula a aceleração com base na 2ª Lei de Newton (F = ma)
			double aceleracao = 0;
			if (forcaAtiva) {
				aceleracao = forcaAplicada / massa; // a = F / m
			}
			
			// Atualiza a velocidade horizontal da bola com base na aceleração
			velocidadeX += aceleracao * dt; // v = v0 + a * dt
			
			// Aplica o atrito para desacelerar a bola quando a força não está ativa
			if (!forcaAtiva) {
				velocidadeX *= atrito; // Reduz a velocidade
			}
			
			// Atualiza a posição horizontal da bola com base na velocidade
			x += velocidadeX * dt; // x = x0 + v * dt
			
			// Limita a posição da bola para dentro da tela
			if (x < 0) {
				x = 0;
				velocidadeX = 0; // Para a bola ao atingir a borda esquerda
			} else if (x > getWidth() - 20) {
				x = getWidth() - 20;
				velocidadeX = 0; // Para a bola ao atingir a borda direita
			}
			
			repaint(); // Redesenha o painel (chama o método paintComponent)
		});
		timer.start(); // Inicia o timer
		
		// Configura o painel para ouvir eventos de teclado
		setFocusable(true);
		addKeyListener(this);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // Chama o método da superclasse para garantir que o fundo seja desenhado corretamente
		
		Graphics2D g2d = (Graphics2D) g; // Converte o objeto Graphics para Graphics2D (permite usar recursos avançados)
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Ativa o anti-aliasing para suavizar as bordas
		
		// Desenha o fundo branco
		g2d.setColor(Color.WHITE); 
		g2d.fillRect(0, 0, getWidth(), getHeight());
		
		// Desenha a bola (círculo azul)
		g2d.setColor(Color.BLUE);
		g2d.fillOval((int) Math.round(x), 150, 20, 20); // Posição (x, 150) com diâmetro de 20 pixels
	}
	
	// Métodos da interface KeyListener para detectar teclas pressionadas e liberadas
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // Tecla direita pressionada
			forcaAtiva = true; // Ativa a força para mover a bola para a direita
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // Tecla direita liberada
			forcaAtiva = false; // Desativa a força
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// Não utilizado
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Força e Aceleração - 2ª Lei de Newton"); // Título da janela
		ForcaAceleracao panel = new ForcaAceleracao(); // Cria uma instância do painel de animação
		frame.add(panel); // Adiciona o painel à janela
		frame.setSize(400, 400); // Define o tamanho da janela (400x400 pixels)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
		frame.setVisible(true); // Torna a janela visível
	}

}
