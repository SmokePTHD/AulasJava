package dez01classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovimentoCirculo extends JFrame {
   private int x = 150; // Posição inicial X do círculo azul. A variável é privada, então não é acessível fora desta classe.
   private int y = 150; // Posição inicial Y do círculo azul. 
   private final int CIRCULO_DIAMETRO = 50; // Diâmetro do círculo azul.

// Novo
	private int xVermelho = 300; // Posição X inicial do círculo vermelho.
	private int yVermelho = 300; // Posição Y inicial do círculo vermelho.
	private boolean circuloVermelhoVisivel = true; // Controla se o circulo vermelho está visível
   
   public MovimentoCirculo1() {
       setTitle("Mover Círculo"); // Define o título da janela
       setSize(400, 400); // Define o tamanho da janela
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
       setResizable(false); // Evita que a janela seja redimensionada

       // Painel personalizado onde o círculo será desenhado
       DesenhoPainel painel = new DesenhoPainel();
       add(painel); // Adiciona o painel à janela

       // Adiciona um KeyListener para capturar eventos do teclado
       addKeyListener(new KeyListener() {
        // Evento chamado quando a tecla de caractere é pressionada
           @Override
           public void keyTyped(KeyEvent e) {}

           @Override
           public void keyPressed(KeyEvent e) {
               // Calcula os limites do painel
               int limiteDireita = painel.getWidth() - CIRCULO_DIAMETRO;
               int limiteInferior = painel.getHeight() - CIRCULO_DIAMETRO;

               // Move o círculo azul de acordo com a tecla pressionada
               switch (e.getKeyCode()) {
                   case KeyEvent.VK_UP -> y = Math.max(y - 10, 0); // Move para cima
                   case KeyEvent.VK_DOWN -> y = Math.min(y + 10, limiteInferior); // Move para baixo
                   case KeyEvent.VK_LEFT -> x = Math.max(x - 10, 0); // Move para a esquerda
                   case KeyEvent.VK_RIGHT -> x = Math.min(x + 10, limiteDireita); // Move para a direita
               }
               
               // NOVO: Verifica se o círculo azul colidiu com o círculo vermelho
               if(circuloVermelhoVisivel && Math.abs(x - xVermelho) < CIRCULO_DIAMETRO && Math.abs(y - yVermelho) < CIRCULO_DIAMETRO) {
            	   circuloVermelhoVisivel = false; // Elimina o círculo vermelho quando há colisão
               }
				

               painel.repaint(); // Redesenha o painel com a nova posição do círculo
           }

           @Override
           public void keyReleased(KeyEvent e) { // Evento chamado quando a tecla é solta
           }
       });

       setVisible(true); // Torna a janela visível
   }

   // Classe interna para desenhar o círculo
   private class DesenhoPainel extends JPanel {
       @Override
       protected void paintComponent(Graphics g) {
           super.paintComponent(g); // Chama o método da superclasse JPanel para garantir que a pintura seja feita corretamente

           g.setColor(Color.BLUE); // Define a cor do círculo azul
           g.fillOval(x, y, CIRCULO_DIAMETRO, CIRCULO_DIAMETRO); 
           // Desenha o círculo azul com as coordenadas (x, y) e o diâmetro especificado
        
           // NOVO: Desenha o circulo vermelho, se ele estiver visível
        	if (circuloVermelhoVisivel) {
        		g.setColor(Color.RED); // Definir a cor do circulo para vermelho
        		g.fillOval(xVermelho, yVermelho, CIRCULO_DIAMETRO, CIRCULO_DIAMETRO); // Desenha o circulo vermelho
        	}
       }
   }

   public static void main(String[] args) {
       new MovimentoCirculo1(); // Cria e exibe a janela
   }
}


