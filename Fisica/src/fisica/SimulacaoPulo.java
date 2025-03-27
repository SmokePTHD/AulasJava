package fisica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

//Simulação de Pulo e Impulso controlado pelas setas
public class SimulacaoPulo extends JPanel {
	private static final long serialVersionUID = 1L;
	private int personagemX = 200, personagemY = 300; // Posição inicial
	private int velocidadeX = 0; // Velocidade horizontal
	private int velocidadeY = 0; // Velocidade vertical
	private boolean noChao = true; // Verifica se o personagem está no chão
	private final int GRAVIDADE = 1; // Gravidade aplicada a cada frame
	private final int IMPULSO = -15; // Força do pulo
	private final int VELOCIDADE = 5; // Velocidade de deslocamento lateral
	
	public SimulacaoPulo() {
		setFocusable(true);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE && noChao) {
					velocidadeY = IMPULSO; // Aplica o impulso quando a tecla espaço é pressionada
					noChao = false; // O personagem sai do chão
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					velocidadeX = -VELOCIDADE; // Move para a esquerda
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					velocidadeX = VELOCIDADE; // Move para a direita
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
					velocidadeX = 0; // Para o movimento horizontal ao soltar a tecla
				}
			}
		});
		
		// Timer para atualizar a simulação a cada 16ms (~60 FPS)
		Timer timer = new Timer(16, e -> atualizar());
		timer.start();
	}
	
	private void atualizar() {
		velocidadeY += GRAVIDADE; // Aplica a gravidade
		personagemY += velocidadeY; // Atualiza a posição vertical
		personagemX += velocidadeX; // Movimento lateral controlado pelas setas
		
		// Verifica se o personagem atinge o chão
		if (personagemY >= 300) {
			personagemY = 300;
			velocidadeY = 0;
			noChao = true;
		}
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight()); // Fundo
		
		g.setColor(Color.BLUE);
		g.fillRect(personagemX, personagemY, 40, 40); // Personagem
	}
	
	public static void main (String[] args) {
		JFrame frame = new JFrame("Simulacao de Pulo e Impulso");
		SimulacaoPulo panel = new SimulacaoPulo();
		frame.add(panel);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
