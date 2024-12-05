package dez01classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovimentoCirculo2 extends JFrame {
   private int x = 150; // Posição inicial X do círculo azul. A variável é privada, então não é acessível fora desta classe.
   private int y = 150; // Posição inicial Y do círculo azul. 
   private final int CIRCULO_DIAMETRO = 50; // Diâmetro do círculo azul.

	private int xVermelho = 300; // Posição X inicial do círculo vermelho.
	private int yVermelho = 300; // Posição Y inicial do círculo vermelho.
	private boolean circuloVermelhoVisivel = true; // Controla se o circulo vermelho está visível
	private final int VELOCIDADE = 5; // NOVO: Velocidade do movimento do círculo vermelho
	private int direcao = 0; // NOVO: Direção do movimento (0: direita, 1: baixo, 2: esquerda, 3: cima)
	
	private boolean colisao = false; // NOVO: Verifica se ocorreu a colisão
	
   // ALTERADO
   public MovimentoCirculo2() {
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
       
       // NOVO: Thread (linha de execução demtro de um processo) para mover o círculo vermelho ao longo das bordas
       new Thread(() -> {
    	   while(!colisao) { // Loop infinito para mover o círculo vermelho
    		   moverCirculoVermelho();
    		   painel.repaint(); // Redesenha o painel
    		   try {
    			   Thread.sleep(30); // Paragem de 30 milisegundos para controlar a velocidade e suavidade do movimento
    		   } catch (InterruptedException e) {
    			   e.printStackTrace(); // Trata interrupções no thread
    		   }
    	   }
    	   System.out.println("Colisão detectada!"); // Imprime mensagem quando ocorre a colisão
       }).start();
   }
   
   // NOVO: Método para mover o círculo vermelho pelas bordas
   private void moverCirculoVermelho() {
	   switch (direcao) {
		   case 0: //Movimento para a direita
			   xVermelho += VELOCIDADE;
			   if (xVermelho >= getWidth() - CIRCULO_DIAMETRO) { // Limite direito
				   xVermelho = getWidth() - CIRCULO_DIAMETRO - 25; // Impede que ultrapasse o limite direito
				   direcao = 1; // Muda para a baixo
			   }
			   break;
		   case 1: // Movimento para baixo
			   yVermelho += VELOCIDADE;
			   if (yVermelho >= getHeight() - CIRCULO_DIAMETRO) { // Limite Inferior
				   yVermelho = getHeight() - CIRCULO_DIAMETRO - 40; // Impede que ultrapasse o limite inferior
				   direcao = 2; // Muda para esquerda
			   }
			   break;
		   case 2: // Movimento para a esquerda
			   xVermelho -= VELOCIDADE;
			   if (xVermelho <= 0) { // Limite esquerdo
				   xVermelho = 0; // Impede que ultrapasse o limite esquerdo
				   direcao = 3; // Muda para cima
			   }
			   break;
			   
		   case 3: // Movimento para baixo
			   yVermelho -= VELOCIDADE;
			   if (yVermelho <= 0) { // Limite superior
				   yVermelho = 0; // Impede que ultrapasse o limite superior
				   direcao = 0; // Muda para cima
			   }
			   break;
	   }
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
       new MovimentoCirculo2(); // Cria e exibe a janela
   }
}


