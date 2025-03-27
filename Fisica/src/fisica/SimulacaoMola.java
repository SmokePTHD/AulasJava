package fisica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionListener;

//Simulação de uma mola oscilando com ativação por tecla
public class SimulacaoMola extends JPanel implements ActionListener{
    private static final long serialVersionUID = 1L;
    private int baseY = 200; // Posição de equilíbrio da mola
    private int posY = baseY; // Posição vertical inicial do objeto
    private double velocidade = 0; // Velocidade da oscilação
    private final double K = 0.1; // Constante elástica da mola
    private final double MASSA = 5; // Massa do objeto pendurado
    private final double ATRITO = 0.02; // Simulação de amortecimento
    private Timer timer;
    private boolean oscilando = false; // Define se a simulação está ativa
    
    public SimulacaoMola() {
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override 
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (!oscilando) {
                        oscilando = true;
                        velocidade = 5; // Impulso inicial ao pressionar espaço
                    }
                }
            }
        });
        timer = new Timer(16, this); // Atualiza a cada 16ms (~60FPS)
        timer.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	if (oscilando) {
    		double forcaMola = -K * (posY - baseY); // Força restauradora de uma mola, Lei de Hooke F=−k⋅x
    		double aceleracao = forcaMola / MASSA; // F = m * a
    		velocidade += aceleracao; // Atualiza a velocidade
    		velocidade *= (1.0 - ATRITO); // Amortecimento gradual
    		posY += velocidade; // Atualiza a posição
    		
    		if (Math.abs(velocidade) < 0.01 && Math.abs(posY - baseY) < 0.5) {
    			oscilando = false; // Para a simulação quando a oscilação é insignificante
    		}
    	}
    	repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, getWidth(), getHeight()); // Fundo
    	
    	g.setColor(Color.WHITE); 
    	g.drawLine(getWidth() / 2, 50, getWidth() / 2, posY); // Desenha a mola
    	
    	g.setColor(Color.RED);
    	g.fillOval(getWidth() / 2 - 20, posY, 40, 40); // Desenha a massa suspensa
    }
    
    public static void main (String[] args) {
    	JFrame frame = new JFrame("Simulacao de Molas e Oscikacoes");
    	SimulacaoMola panel = new SimulacaoMola();
    	frame.add(panel);
    	frame.setSize(400, 400);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
    }
}