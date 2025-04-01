package fisica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SimulacaoProjetil extends JPanel implements ActionListener, KeyListener {
	private Timer timer;
	private ArrayList<Projetil> projeteis;
	private double angulo = Math.toRadians(45); //
	private double forca = 20; //
	
	public SimulacaoProjetil() {
		timer = new Timer(16, this); // 
		projeteis = new ArrayList<>();
		setFocusable(true);
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (Projetil p : projeteis) {
			p.mover();
		}
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(50, getHeight() - 20, 100, 10); // 
		
		for (Projetil p : projeteis) {
			p.desenhar(g);
		}
		
		g.setColor(Color.RED);
		int x1 = 100;
		int y1 = getHeight() - 20;
		int x2 = x1 + (int) (50 * Math.cos(angulo));
		int y2 = y1 + (int) (50 * Math.sin(angulo));
		g.drawLine(x1, y1, x2, y2); //
		
		g.drawString("Ângulo: " + Math.toDegrees(angulo) + "º", 10, 10);
		g.drawString("Força: " + forca, 10, 40);
		g.drawString("Setas esquerda e direita controlam a força, cima e baico controlam o ângulo", 10, 60);
	}
		
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			angulo -= Math.toRadians(5); //
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			angulo += Math.toRadians(5); //
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			forca = Math.max(5, forca - 2); //
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			forca = Math.max(5, forca + 2); //
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			projeteis.add(new Projetil(100, getHeight() - 20, forca, angulo)); //
		}
		repaint();
	}
		
	@Override
	public void keyReleased(KeyEvent e) {}
		
	@Override
	public void keyTyped(KeyEvent e) {}
		
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Simulação de Projéteis");
		SimulacaoProjetil panel = new SimulacaoProjetil();
		frame.add(panel);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class Projetil {
	private double x, y;
	private double velocidadeX, velocidadeY;
	private final double gravidade = 0.5; //
	
	public Projetil(double x, double y, double forca, double angulo) {
		this.x = x;
		this.y = y;
		this.velocidadeX = forca * Math.cos(angulo);
		this.velocidadeY = forca * Math.sin(angulo); //
	}
	
	public void mover() {
		x += velocidadeX;
		velocidadeY += gravidade; //
		y += velocidadeY;
	}
	
	public void desenhar(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval((int) x, (int) y, 10, 10);
	}
}
