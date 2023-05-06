package bsp;

import bsp.Game;
import static bsp.Segmento.ATRAS;
import static bsp.Segmento.FRENTE;
import java.awt.Polygon;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

public class BSPTree {

    BSPTree frente, atras;
    Poligono raiz;

    public BSPTree() {
    }

    public BSPTree(BSPTree frente, BSPTree atras, Poligono raiz) {
        this.frente = frente;
        this.atras = atras;
        this.raiz = raiz;
    }

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

    public void addTree(BSPTree tree, Poligono poligono, int aux) {
        if (tree.raiz == null) {
            tree.raiz = poligono;
        } else if (aux == 1) {
            //Adiciona na esquerda
        } else if (aux == 2) {

        }
    }

    public void montaSubArvore(ArrayList<Poligono> lista1, BSPTree inicial, BSPTree atualDireita, BSPTree atualEsquerda) {
        if (lista1.isEmpty()) {
            return;
        }
        Random r = new Random();
        int c = r.nextInt(lista1.size());
        //Escolhe um novo poligono para ser a referencia da frente
        Poligono temporario = lista1.get(c);
        lista1.remove(c);
        if (inicial.atras.raiz.equals(null)) {
            //Se cair aqui dentro quer dizer que a sub-branch da esquerda nao tinha nada
            inicial.atras.raiz = temporario;
            atualDireita = inicial.atras;
            atualDireita.raiz.retaSuperior.acharNormal();
            montaSubArvore(lista1, inicial, atualDireita, atualEsquerda);
        }
        //Agora pega outro poligono para testar
        int d = r.nextInt(lista1.size());
        Poligono teste = lista1.get(d);

        if (atualDireita.raiz.retaSuperior.getLado(teste.retaSuperior.linha.getX1(), teste.retaSuperior.linha.getY1()) == -1) {//SE O ATUAL ESTA ATRAS
            //Esta atras
            BSPTree esquerdaadiciona = new BSPTree();
            esquerdaadiciona.setRaiz(teste);
            atualDireita.atras.setAtras(esquerdaadiciona);
            lista1.remove(d);
        } else if (atualDireita.raiz.retaSuperior.getLado(teste.retaSuperior.linha.getX1(), teste.retaSuperior.linha.getY1()) == 1) {
            //Esta a frente
            BSPTree direitaadiciona = new BSPTree();
            direitaadiciona.setRaiz(teste);
            atualDireita.atras.setAtras(direitaadiciona);
            lista1.remove(d);
        }
        montaSubArvore(lista1, inicial, atualDireita, atualEsquerda);
    }

    public BSPTree montaArvore(ArrayList<Poligono> lista) {
        BSPTree inicial = new BSPTree();
        BSPTree atualEsquerda = new BSPTree();
        BSPTree atualDireita = new BSPTree();
        //Declaracao dos tipos base
        //Cria-se um poligono qualquer, ele vai ser substituido depois
        if (lista.isEmpty()) {
            System.out.println("Lista vazia");
            return new BSPTree();
        }
        Poligono raiz = new Poligono(123, 123, 123, 123);
        ArrayList<Poligono> estaAtras = new ArrayList<>();
        ArrayList<Poligono> estaAFrente = new ArrayList<>();

        Random r = new Random();

        int a = r.nextInt(lista.size());
        //Fazer a raiz receber os pontos do elemento selecionado aleatoriamente da lista
        raiz.retaSuperior.linha.setLine(lista.get(a).retaSuperior.linha);
        raiz.retaSuperior.acharNormal();

        inicial.raiz = lista.get(a);
        lista.remove(a);

        while (!lista.isEmpty()) {
            //Sorteia outro random
            int b = r.nextInt(lista.size());
            //Declara um novo poligono por causa do jeito que o codigo foi escrito
            Poligono pol1 = new Poligono(lista.get(b).retaSuperior);
            //Devo retirar os segmentos para jogar no metodo abaixo
            Segmento seg2 = raiz.retaSuperior;
            Segmento seg1 = new Segmento(pol1.retaSuperior.linha.getX1(), pol1.retaSuperior.linha.getX2(), pol1.retaSuperior.linha.getY1(), pol1.retaSuperior.linha.getY2());

            //Se nao for null quer dizer que se encontram as retas - YODA
            if (raiz.retaSuperior.checarInterseccao(seg1, seg2) != null) {
                ArrayList retornoDivisaoSegmentos = pol1.retaSuperior.checarInterseccao(seg1, seg2);
                //adiciona os dois novos sub-segmentos
                lista.add((Poligono) retornoDivisaoSegmentos.get(0));
                lista.add((Poligono) retornoDivisaoSegmentos.get(1));
                lista.remove(b);
            } else if (raiz.retaSuperior.getLado(pol1.retaSuperior.linha.getX1(), pol1.retaSuperior.linha.getY1()) == -1) {
                //ATRAS
                estaAtras.add(pol1);
                lista.remove(b);
            } else if (raiz.retaSuperior.getLado(pol1.retaSuperior.linha.getX1(), pol1.retaSuperior.linha.getY1()) == 0) {
                estaAtras.add(pol1);
                lista.remove(b);
                //COLINEAR
            } else if (raiz.retaSuperior.getLado(pol1.retaSuperior.linha.getX1(), pol1.retaSuperior.linha.getY1()) == 1) {
                estaAFrente.add(pol1);
                lista.remove(b);
                //FRENTE
            }
            //FIM DESSE CONDICIONAL IMENSO
        }
        //agora vamos montar a arvore com os sub-ArrayLists separados
        montaSubArvore(estaAtras, inicial, atualDireita, atualEsquerda);
        montaSubArvore(estaAFrente, inicial, atualDireita, atualEsquerda);
        //Agora que processamos a arvore vamos montala com os dois sub-branches
        inicial.atras = atualDireita;
        inicial.frente = atualEsquerda;
        return inicial;
    }

    public int retornaBranchLivre() {
        //mas sim testar de forma mais simples se o nodo atual tem filhos
        //Isso tende a economizar tempo com testes
        //Retorna 0 se não há branchs livres
        //Retorna 1 se o branch de tras esta livre
        //Retorna 2 se o branch da direita esta livre
        //Retorna 3 se os dois estao livres
        // Tem que fazer a traversal
        if (this.atras.raiz == null && this.frente.raiz == null) {
            return 3;
        }
        if (this.atras.raiz == null) {
            return 1;
        } else if (this.frente.raiz == null) {
            return 2;
        } else {
            return 0;
        }
    }
}
