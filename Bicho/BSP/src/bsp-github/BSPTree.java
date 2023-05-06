/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsp;

import static bsp.Segmento.ATRAS;
import static bsp.Segmento.FRENTE;
import java.awt.Polygon;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BSPTree {
   
    BSPTree frente,atras;
    Poligono raiz;

    public BSPTree getFrente() {
        return frente;
    }

    public void setFrente(BSPTree frente) {
        this.frente = frente;
    }

    public BSPTree getAtras() {
        return atras;
    }

    public void setAtras(BSPTree atras) {
        this.atras = atras;
    }

    public Poligono getRaiz() {
        return raiz;
    }

    public void setRaiz(Poligono raiz) {
        this.raiz = raiz;
    }
    
    public BSPTree(ArrayList<Poligono> poligono){
        ArrayList<Poligono> polFrente,polAtras;
        polFrente = new ArrayList<>();
        polAtras = new ArrayList<>();
       
        raiz = poligono.get(0);
        if(poligono.isEmpty()){
            return;
        }
        for(int i =0;i < poligono.size();i++){
            Poligono temp = poligono.get(i);
            if(temp.equals(raiz))poligono.remove(i);
            
            if(raiz.retaSuperior.checarInterseccao(raiz.retaSuperior, temp.retaSuperior) != null){
                ArrayList<Poligono> quebraPoligono =  raiz.retaSuperior.checarInterseccao(raiz.retaSuperior, temp.retaSuperior);
                poligono.remove(i);
                poligono.add(quebraPoligono.get(0));
                poligono.add(quebraPoligono.get(1));
            }
            if(raiz.retaSuperior.posicaoSegmento(temp.retaSuperior) == FRENTE ){
                polFrente.add(temp); 
            }else if(raiz.retaSuperior.posicaoSegmento(temp.retaSuperior) == ATRAS){
                polAtras.add(temp);
            }
        }
        //if(!polFrente.isEmpty()){
        //    frente = new BSPTree(polFrente);
        //}else frente = null;
        //if(!polAtras.isEmpty()){
         //   atras = new BSPTree(polAtras);
        //}else atras = null; 
    }
    
    public void montaArvore(ArrayList<Poligono> lista){  
        //TESTAR CASO BASE COM APENAS DOIS SEGMENTOS ADICONADOS NO ARRAY
        //SE PASSAR, CRIAR UM CASO COM MAIS ARRAYS E VER ARVORE MONTADA
        //DEPOIS IMPLEMENTAR A TRAVERSAL
        if(lista.isEmpty()){
            return;
            }
        Random r = new Random();
        int a = r.nextInt(lista.size());
        int b = r.nextInt(lista.size());
        while(b == a){
            b = r.nextInt(lista.size());
        }
        Poligono aux = new Poligono(lista.get(b*lista.size()).retaSuperior.linha);
        //Pega o conteudo da posicao r do array
        //for(int i=0; i<lista.size();i++){
        //    System.out.println("ITERACAO"+i +" COM CONTEUDO"+ lista.get(i));
        if(lista.get(a*lista.size()).retaSuperior.getLado(aux.retaSuperior.linha.getX1(), aux.retaSuperior.linha.getY1()) == -1){
            //ATRAS
        }
        else if(lista.get(a*lista.size()).retaSuperior.getLado(aux.retaSuperior.linha.getX1(), aux.retaSuperior.linha.getY1()) == 0){
            //COLINEAR
        }
        else if(lista.get(a*lista.size()).retaSuperior.getLado(aux.retaSuperior.linha.getX1(), aux.retaSuperior.linha.getY1()) == 1){
            //FRENTE
        }
        else if(lista.get(a*lista.size()).retaSuperior.getLado(aux.retaSuperior.linha.getX1(), aux.retaSuperior.linha.getY1()) == 2){
            //CORTA
        }
        //}
        lista.remove(a);
            //Verifica se esta a frente ou atras
    }
    
    public int retornaBranchLivre(){
        //A ideia dessa funcao nao é aplicar uma Traversal
        //mas sim testar de forma mais simples se o nodo atual tem filhos
        //Isso tende a economizar tempo com testes
        //Retorna 0 se não há branchs livres
        //Retorna 1 se o branch de tras esta livre
        //Retorna 2 se o branch da direita esta livre
        //Retorna 3 se os dois estao livres
        // Tem que fazer a traversal
        if(this.atras.raiz == null && this.frente.raiz == null){
            return 3;
        }
        if(this.atras.raiz == null){
            return 1;
        }
        else if(this.frente.raiz == null){
            return 2;
        }
        else{
            return 0;
        }
    }
}

