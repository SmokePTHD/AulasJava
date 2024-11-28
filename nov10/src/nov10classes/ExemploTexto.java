package nov10classes;

import javax.swing.*;
import java.awt.*;

public class ExemploTexto extends JPanel {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // Limpa a área antes de desenhar
		
		Graphics2D g2d = (Graphics2D) g; // Convertendo Graphics para Graphics2D para melhores recursos
		
		// Definir a cor para o texto
		g2d.setColor(Color.BLACK); // Cor do texto
		
		// Desenha texto simples
		g2d.setFont(new Font("Serif", Font.PLAIN, 24)); // Define a fonte (nome, estilo, tamanho)
		g2d.drawString("Texto em simples", 50, 50); // Desenha o texto na posição (50, 50)
		
		// Texto em negrito	
		g2d.setFont(new Font("Serif", Font.BOLD, 24)); // Define a fonte (nome, estilo, tamanho)
		g2d.drawString("Texto em negrito", 50, 50); // Desenha o texto
		
		// Texto em itálico
		g2d.setFont(new Font("Serif", Font.ITALIC, 24)); // Define a fonte (nome, estilo, tamanho)
		g2d.drawString("Texto em itálico", 50, 50); // Desenha o texto
		
		// Texto em negrito e itálico
		
		
		// Usando uma fonte sans-serif
		g2d.setFont(new Font("SansSerif", Font.PLAIN, 24)); // Define a fonte (nome, estilo, tamanho)
		g2d.drawString("Texto em SansSerif", 50, 250); // Desenha o texto
		
		// Texto com fundo colorido
		g2d.setColor(Color.WHITE);
		g2d.fillRect(50, 300, 300, 50);
		g2d.setColor(Color.RED);
		g2d.setFont(new Font("Arial", Font.PLAIN, 24)); // Define a fonte (nome, estilo, tamanho)
		g2d.drawString("Texto com fundo branco e texto vermelho", 50, 250); // Desenha o texto
		
		// Texto com contorno (usando Stroke)
		g2d.setColor(Color.YELLOW);
		g2d.setFont(new Font("Arial", Font.PLAIN, 24)); // Fonte Courier New
		g2d.drawString("Texto com contorno", 50, 400); // Desenha o texto
		g2d.setStroke(new BasicStroke(2)); // Define a espessura do contorno
		g2d.setColor(Color.RED); // Cor do contorno
		g2d.drawString("Texto com contorno", 50, 400); // Desenha o contorno do texto
	}
	
	public static void main(String[] args) {
		// Criando a janela para exibir o texto
		JFrame frame = new JFrame("Exemplo de Texto e Fontes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a aplicação ao fechar a janela
		frame.setSize(400, 500); // Define o tamanho da janela
		
		// Adiciona o painel de desenho à janela
		ExemploTexto painel = new ExemploTexto(); // Cria a instância do painel
		frame.add(painel); // Adiciona o painel ao frame
		
		// Torna a janela visível
		frame.setVisible(true);
		
	}
}
