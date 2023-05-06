/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

// Esta é a classe que representa nosso jogo. Ela é derivada de "Game", que
// possui o motor do jogo e chama os métodos abaixo quando necessário.
public class JogoCirculo1 extends Game implements KeyListener {

    // Variáveis necessárias para nosso jogo.
    // Elas armazenam a posição do círculo (x,y) e a velocidade que ela anda.
    int x1;
    int y1;
    int x2;
    int y2;
    int m;
    int xDoOlho, yDoOlho;
    boolean rotate = false;
    boolean keyEvent = false;
    Ellipse2D.Float c = new Ellipse2D.Float(0, 0, 100, 100);

    //HashMap<Integer, Boolean> keyPool;
    BSPTree tree;
    BSPTree esquerda;
    BSPTree direita;

    public void separaArvore() {
        esquerda = tree.frente;
        //DrawTree(BSPtree) { 
        //if (eye is in front of root){ 
        //	DrawTree(BSPtree->behind) 
        //	DrawPoly(BSPtree->root) 
        //	DrawTree(BSPtree->front) 
        //} 
        //else { 	
        //	DrawTree(BSPtree->front) 
        //	DrawPoly(BSPtree->root) 
        //	DrawTree(BSPtree->behind) 
        //} 
        //} 
        //direita = tree.tras;
    }

    public void onLoad(Graphics2D h) {
    }

    public void onUnload() {
        // Este método é chamado quando o jogo termina.
        // Não é preciso fazer nada para este jogo.
    }

    public void onUpdate() {
        // Este método é chamado cada vez que a lógica do jogo precisa ser
        // atualizada. Aqui mudamos os valores das variáveis para
        // fazer a bola se mover na tela, rebatendo nas bordas.
        //getHeight() getWidth()
        if (keyEvent == true) {
            System.out.println("Funciona");
            keyEvent = false;
        }
        Random r = new Random();
        int a = r.nextInt();
        x1 = x1 * a;
        y1 = y1 * a;

    }

    public void onRender(Graphics2D g) {
        // Este método é chamado cada vez que é preciso atualizar a imagem
        // do jogo na tela. É aqui que desenyhamos abola na posição 
        // armazenada nas variáveis.
        if (rotate = true) {
            g.rotate(3.0);
            rotate = false;
        }
        g.drawLine(x1, y1, x2, y2);
        g.setColor(Color.white);
        g.drawLine(0, 0, x1, y1);

    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                keyEvent = true;
                xDoOlho += 2;
                yDoOlho += 2;
                break;
            case KeyEvent.VK_DOWN:
                keyEvent = true;
                xDoOlho += 2;
                yDoOlho += 2;
                break;
            case KeyEvent.VK_LEFT:
                keyEvent = true;
                xDoOlho += 2;
                yDoOlho += 2;
                break;
            case KeyEvent.VK_RIGHT:
                keyEvent = true;
                xDoOlho += 2;
                yDoOlho += 2;
                break;
            case KeyEvent.VK_SPACE:
                keyEvent = true;
                xDoOlho = 60;
                yDoOlho = 60;
                break;
            case KeyEvent.VK_R:
                keyEvent = true;
                rotate = true;
                break;
            case KeyEvent.VK_ESCAPE:
                keyEvent = true;
                break;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {

    }
    // Os métodos acima são chamados automaticamente pelo "motor" do jogo que
    // é herdado da classe Game. Abra o arquivo game.java e veja lá o que ocorre
    // quando o programa roda.

    @Override
    public void onLoad() {
        
    }
}
