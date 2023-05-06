/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsp;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args){
        Poligono p,p1,p2,p3;
        p = new Poligono(2.0,3.0,1.0,3.0);
        p1 = new Poligono(3.0,2.0,4.0,10.0);
        ArrayList<Poligono> pol = new ArrayList<>();
        pol.add(p);
        pol.add(p1);
        BSPTree teste = new BSPTree(pol);
        System.out.println(p.retaSuperior.posicaoSegmento(p1.retaSuperior));
        System.out.println(teste.raiz.retaSuperior.linha.getX1());
        System.out.println(p.retaSuperior.normalY);
        teste.montaArvoreRecursivamente(pol);
    }
}
