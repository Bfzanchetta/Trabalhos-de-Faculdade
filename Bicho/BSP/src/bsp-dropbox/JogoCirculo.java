/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsp;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class JogoCirculo extends Game implements KeyListener{
    ArrayList<Poligono> lista1;
    
    int x;
    int y;
    int sx;
    int sy;

    public void onLoad() {
        ArrayList<Poligono> lista = new ArrayList<>();
        BSPTree arvore = new BSPTree();
        arvore.setRaiz(new Poligono(2.0,2.3,4.0,6.0));
        int i = 0;
        while(i!=5){
            Random a = new Random();
            Random b = new Random();
            int a1 = a.nextInt(10);
            int b1 = b.nextInt(10);
            Poligono aux = new Poligono(a1*15, b1*20, a1*b1*2, (a1+1)/(b1+1)*3);
            //As duas linhas de baixo randomizam as normais
            aux.retaSuperior.acharNormal();
            i++;
            lista.add(aux);
        }
        this.lista1 = lista;
        x = 250;
        y = 250;
        
    }

    public void onUnload() {
    }

    public void onUpdate() {
        x += sx;
        y += sy;
    }

    public void onRender(Graphics2D g) {
        g.setColor(Color.white);
        g.drawOval(x, y, 10, 10);
        g.drawLine(10, 10, 200, 200);
        int i=0;
        while(i<lista1.size()){
            double x1 = lista1.get(i).retaSuperior.linha.getX1();
            double y1 = lista1.get(i).retaSuperior.linha.getY1();
            double x2 = lista1.get(i).retaSuperior.linha.getX2();
            double y2 = lista1.get(i).retaSuperior.linha.getY2();
            System.out.println("X1"+x1+"y1"+y1+"X2"+x2+"Y2"+y2);
            g.drawLine((int)x1, (int)y1 ,(int)x2 ,(int)y2);
            i++;
        }
    }
    
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                System.out.println("Funciona");
                break;
            case KeyEvent.VK_DOWN:

                break;
            case KeyEvent.VK_LEFT:

                break;
            case KeyEvent.VK_RIGHT:

                break;
            case KeyEvent.VK_SPACE:

                break;
            case KeyEvent.VK_R:

                break;
            case KeyEvent.VK_ESCAPE:

                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public ArrayList<Poligono> chamaParametros(ArrayList<Poligono> lista) {
        ArrayList<Poligono> lista1 = lista;
        return lista1;
    }
}

