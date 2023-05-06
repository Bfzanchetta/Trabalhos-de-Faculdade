package bsp;

import java.awt.Color;

public class Poligono {   
   
   Segmento retaSuperior;
    //private int altura = 20;
   public Poligono(double x1,double x2, double y1, double y2) {
        this.retaSuperior = new Segmento(x1,x2,y1,y2);
        //this.cor = cor;
    }

    public Poligono(Segmento retaSuperior) {
        this.retaSuperior = retaSuperior;
    }
   
   
  
 }
