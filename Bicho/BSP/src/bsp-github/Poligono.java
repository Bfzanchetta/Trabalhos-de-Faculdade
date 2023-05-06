/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsp;

import java.awt.Color;

public class Poligono {   
   
    Segmento retaSuperior;
    //private int altura = 20;
   public Poligono(double x1,double x2, double y1, double y2) {
        this.retaSuperior = new Segmento(x1,x2,y1,y2);
        //this.cor = cor;
    }
  
 }
