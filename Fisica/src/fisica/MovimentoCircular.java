package fisica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 
public class MovimentoCircular extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private double angulo = 0; //
	private double velocidadeAngular = 0; //
	private final int RAIO = 100; //
	private final double ACELERACAO = 0.005; //
	private final double ATRITO = 0.99; //
	private Timer timer;
	
	public MovimentoCircular() {
		setFocusable(true);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					velocidadeAngular += ACELERACAO; //
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					velocidadeAngular -= ACELERACAO;//
				}
					
			}
		});
		
		timer = new Timer(16, this); //
		timer.start();;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		velocidadeAngular *= ATRITO; //
		angulo += velocidadeAngular; //
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight()); //
		
		int centroX = getWidth() / 2;
		int centroY = getHeight() / 2;
		
		//
		int x = centroX - (int) (RAIO * Math.cos(angulo));
		int y = centroY - (int) (RAIO * Math.sin(angulo));
		
		g.setColor(Color.WHITE);
		g.drawOval(centroX - RAIO, centroY - RAIO, RAIO * 2, RAIO * 2); //
		
		g.setColor(Color.RED);
		g.fillOval(x - 10, y - 10, 20, 20);//
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Movimento Circular");
		MovimentoCircular panel = new MovimentoCircular();
		frame.add(panel);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
