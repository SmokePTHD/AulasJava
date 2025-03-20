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
	
	// L
	private final ArrayList<Particula> particulas = new ArrayList<>();
	private final Random random = new Random();
	
	public SimulacaoParticulas() {
		// Timer
		Timer timer = new Timer(16, e -> atualizar());
		timer.start();
	}
	
	private void atualizar() {
		// Atualizar
		Iterator<Particula> iterator = particulas.iterator();
		while (iterator.hasNext()) {
			Particula p = iterator.next();
			p.atualizar();
			if (p.y > getHeight()) {
				iterator.remove(); // Remove
			}
		}
		// Adiciona 
		if (particulas.size() < 100) {
			particulas.add(new Particula(random.nextInt(getWidth()), 0));
		}
		repaint(); // Redesenha
	}
	
	@Override
	protected void paintComponent(Graphic g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		// Ativa o anti
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// Define o
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		
		// Desenha as 
		g2d.setColor(Color.CYAN);
		for (Particula p : particulas) {
			g2d.fillOval((int) p.x, (int) p.y, 4, 4);
		}
	}
}
