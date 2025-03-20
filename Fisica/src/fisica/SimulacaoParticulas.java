package fisica;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Random.*;

// Simuilação de Partículas - Chuva
public class SimulacaoParticulas extends JPanel {
	private static final long serialVersionUID = 1l;
	
	// Lista que armazena todas as partículas na simulação
	private final ArrayList<Particula> particulas = new ArrayList<>();
	private final Random random = new Random();
	
	public SimulacaoParticulas() {
		// Timer para atualizar a simulação a cada 16ms (~60 FPS)
		Timer timer = new Timer(16, e -> atualizar());
		timer.start();
	}
	
	private void atualizar() {
		// Atualiza a posição de cada partícula
		Iterator<Particula> iterator = particulas.iterator();
		while (iterator.hasNext()) {
			Particula p = iterator.next();
			p.atualizar();
			if (p.y > getHeight()) {
				iterator.remove(); // Remove partículas que saem da tela
			}
		}
		// Adiciona novas partículas até um máximo de 100 ativas
		if (particulas.size() < 100) {
			particulas.add(new Particula(random.nextInt(getWidth()), 0));
		}
		repaint(); // Redesenha a tela após atualização
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		// Ativa o antialiasing para suavizar os contornos das partículas
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// Define o fundo da tela como preto
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		
		// Desenha as partículas na cor ciano
		g2d.setColor(Color.CYAN);
		for (Particula p : particulas) {
			g2d.fillOval((int) p.x, (int) p.y, 4, 4);
		}
	}
	
	public static void main(String[] args) {
		// Configuração da janela
		JFrame frame = new JFrame("Simulação de Partículas - Chuva");
		SimulacaoParticulas panel = new SimulacaoParticulas();
		frame.add(panel);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

// Classe que representa uma partícula
class Particula {
	double x, y, velocidadeY;
	
	public Particula(double x, double y) {
		this.x = x;
		this.y = y;
		
		// Define a velocidade vertical aleatória entre 2 e 6 pixels por frame
		this.velocidadeY = 2 + Math.random() * 4;
	}
	
	// Atualiza a posição da partícula
	public void atualizar() {
		y += velocidadeY;
	}
}