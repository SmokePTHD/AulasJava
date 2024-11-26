package nov10classes;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath; // Importa a class GeneralPath para desenhar formais mais complexas

public class FormasLivresExemplo extends JPanel {
	
	 @Override
	 protected void paintComponent(Graphics g) {
		 super.paintComponent(g); // Limpa a área de desenho antes de começar a desenhar
		 
		 // Desenho de uma linha reta
		 g.setColor(Color.BLACK); // Define a cor da linha como preta
		 g.drawLine(10, 10, 200, 50); // Desenha uma linha do ponto (10, 10) até (200, 50)
		 
		 // Desenho de um polígono (forma livre com vários pontos)
		 int[] xPoints = {50, 100, 150, 200, 250}; // Coordenadas X dos pontos do polígono
		 int[] yPoints = {100, 50, 150, 50, 100}; // Coordenadas Y dos pontos do polígono
		 int nPoints = 5; // Número de pontos que formam o polígono
		 g.setColor(Color.BLUE); // Define a cor do polígono como azul
		 g.drawPolygon(xPoints, yPoints, nPoints); // Desenha o polígono com os pontos definidos
		 
		 // Desenho de um polígono preenchido (com cor)
		 int[] xPoints2 = {300, 350, 400, 350}; // Coordenadas X dos pontos do polígono
		 int[] yPoints2 = {150, 100, 150, 200}; // Coordenadas Y dos pontos do polígono
		 g.setColor(Color.ORANGE); // Define a cor do polígono como laranja
		 g.fillPolygon(xPoints2, yPoints2, 4); // Desenha e preenche os poligono com 4 pontos
		 
		 // Desenho de uma curva de Bézzier (usando Graphics2D)
		 Graphics2D g2d = (Graphics2D) g; // Cast para Graphics2D para usar método avançados de desenhos
		 g2d.setColor(Color.RED); // Define a cor da curva como vermelha
		 g2d.setStroke(new BasicStroke(2)); // Define a espessura da linha como 2 pixels
		 
		 // Desenho de um arco (parte de uma curva circular)
		 g2d.drawArc(100, 200, 150, 100, 0, 180); // Desenha um arco (circular) com o canto superior esquerdo em (100, 200), largura 150, altura 100, e ângulo de 0 a 180 graus
		 
		 // Desenho de uma curva Bézzier cúbica com GeneralPath
		 g2d.setColor(Color.GREEN); // Define a cor da curva como verde
		 g2d.setStroke(new BasicStroke(1)); // Define a espessura da linha como 1 pixel.
		 
		 // Criando uma forma de arbitrária usando GeneralPath
		 GeneralPath path = new GeneralPath(); // Criar um novo caminho
		 path.moveTo(50, 300); // Move o "ponteiro" do caminho para o ponto inicial (50, 300)
		 path.curveTo(100, 250, 150, 350, 200, 300); // Desenha uma curva de Bézzier com dois pontos de controle (100, 250) e (150, 350), terminando em (200, 300)
		 path.lineTo(250, 350); // Desenha uma linha reta do ponto atual até o ponto (250, 350)
		 path.closePath(); // Fecha o caminho (curva e linha) 
	 }
}
