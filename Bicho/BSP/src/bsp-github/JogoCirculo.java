package aoj.djj.exemplo01;

import aoj.djj.core.Game;
import java.awt.Color;
import java.awt.Graphics2D;

// Esta é a classe que representa nosso jogo. Ela é derivada de "Game", que
// possui o motor do jogo e chama os métodos abaixo quando necessário.
public class JogoCirculo extends Game {

    // Variáveis necessárias para nosso jogo.
    // Elas armazenam a posição do círculo (x,y) e a velocidade que ela anda.
    int x1;
    int y1;
    int x2;
    int y2;
    int m;
    
    BSPTree tree;
    BSPTree esquerda;
    BSPTree direita;
    
    public void separaArvore(){
        esquerda = tree.frente;
        direita = tree.tras;
    }
    
    
    public void onLoad() {
        // Este método é chamado quando o jogo é iniciado.
        // Aqui damos os valores iniciais para as variáveis.
        
    }

    public void onUnload() {
        // Este método é chamado quando o jogo termina.
        // Não é preciso fazer nada para este jogo.
    }

    public void onUpdate() {
        // Este método é chamado cada vez que a lógica do jogo precisa ser
        // atualizada. Aqui mudamos os valores das variáveis para
        // fazer a bola se mover na tela, rebatendo nas bordas.
        x += sx;
        y += sy;
        // Toda vez que a posição chega em um limite da tela,
        // a velocidade naquela direção é invertida.
        if (x < 0 || x > getWidth()) {
            sx *= -1;
        }
        if (y < 0 || y > getHeight()) {
            sy *= -1;
        }
    }

    public void onRender(Graphics2D g) {
        // Este método é chamado cada vez que é preciso atualizar a imagem
        // do jogo na tela. É aqui que desenyhamos abola na posição 
        // armazenada nas variáveis.
        g.setColor(Color.white);
        g.drawOval(x, y, 10, 10);
        g.drawLine(x, y, x, y);
    }
    
    // Os métodos acima são chamados automaticamente pelo "motor" do jogo que
    // é herdado da classe Game. Abra o arquivo game.java e veja lá o que ocorre
    // quando o programa roda.
}
