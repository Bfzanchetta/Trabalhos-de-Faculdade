/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsp;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Segmento{
       public static final int ATRAS = -1;
       public static final int FRENTE = 1;
       public static final int COLINEAR = 0;
       public static final int CORTA = 2;
       Line2D linha;
       //Direcao da normal em x e y
       double normalX,normalY;
       public Segmento(double x1,double x2,double y1,double y2){
           this.linha = new Line2D.Double();
           linha.setLine(x1, y1, x2, y2); 
       }
       //Calcula o produto escalar entre o vetor de um ponto qualquer com a normal do segmento
       public int getLado(double x, double y){
           //Cria um vetor do ponto a origem do segmento e calcula o produto escalar
           double produtoEscalar = (x - linha.getX1())*normalX + (y - linha.getY1())*normalY;

           //Se o produto escalar for menor que 0, o ponto esta atras do segmento
           if(produtoEscalar < 0){
               return ATRAS;
           }
           //Se for maior que 0, o ponto esta a frente do segmento
           if(produtoEscalar > 0){
               return FRENTE;
           }
           //Se o produto for 0, o ponto e colinear
           return COLINEAR;
       }

       //Determina a posicao de um segmento em relacao a outro
       public int posicaoSegmento(Segmento segmento){
           
           this.acharNormal();
           int ponto1 = getLado(segmento.linha.getX1(),segmento.linha.getX2());
           int ponto2 = getLado(segmento.linha.getX2(),segmento.linha.getY2());

           //Se os dois forem iguais, retorna a posicao do segmento
           if(ponto1 == ponto2){
               return ponto1;    
           }else if(ponto1 == COLINEAR){
               return ponto2;
           }else if(ponto2 == COLINEAR){
               return ponto1;
           }else
               return CORTA;
       }

       public void acharNormal(){
           //Primeiro acha a equacao da reta
           //Coeficiente angular da reta
           double m = (linha.getY2()- linha.getY1())/(linha.getX2()-linha.getX1());
           double n = (-1)/m;

           //ponto medio
           double XMed = (linha.getX2()+linha.getX1())/2;
           double YMed = (linha.getY2()+linha.getY1())/2; 

           //y=ax+b
           //y - ymed = n (x-xmed)
           //y= nx + (ymed - xmed )

           //normalX = b/a
           //normalY = b
           normalX = (YMed - XMed)/n;
           normalY = YMed - XMed;
       }
       public ArrayList<Poligono> checarInterseccao(Segmento seg1,Segmento seg2){
           if(seg1.linha.intersectsLine(seg2.linha)){
               return null;
           }else{
               Poligono p1,p2;
               Point2D i = getIntersection(seg1.linha,seg2.linha);
               p1 = new Poligono(seg2.linha.getX1(),i.getX(),seg2.linha.getY1(),i.getY());
               p2 = new Poligono(i.getX(),seg2.linha.getX2(),i.getY(),seg2.linha.getY2());
               ArrayList<Poligono> temp = new ArrayList<>();
               temp.add(p1);
               temp.add(p2);
               return temp;
           }
               
       }
       public Point2D getIntersection(Line2D line1, Line2D line2){
           if(!line1.intersectsLine(line2)){
               return null;
           }
              double px = line1.getX1(),
                py = line1.getY1(),
                rx = line1.getX2() - px,
                ry = line1.getY2() - py;
                double qx = line2.getX1(),
                qy = line2.getY1(),
                sx = line2.getX2() - qx,
                sy = line2.getY2() - qy;

         double det = sx * ry - sy * rx;
         if (det == 0) {
             return null;
         } else {
             double z = (sx * (qy - py) + sy * (px - qx)) / det;
             if (z == 0 || z == 1) return null;  // intersection at end point!
             return new Point2D.Double(
                     (float) (px + z * rx), (float) (py + z * ry));
         }
        }
           
    }
