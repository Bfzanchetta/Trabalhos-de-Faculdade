package trabalhodoleonardo;

/**
 *
 * @author Breno
 */
public class Node {

    static Node root;
    
    public static Node getRoot(){
        if(root == null){
            root = new Node("Seu animal tem bigode?", null, new Node("Gato", null, null));
        }
        return root;
    }
    
    String texto;
    Node esquerda;
    Node direita;

    public Node() {
    }

    public Node(String texto) {
        this.texto = texto;
        this.esquerda = null;
        this.direita = null;
    }

    public Node(String texto, Node esquerda, Node direita) {
        this.texto = texto;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Node getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public Node getDireita() {
        return direita;
    }

    public void setDireita(Node direita) {
        this.direita = direita;
    }

    public boolean verificaFolha() {
        if (this.direita == null && this.esquerda == null) {
            return true;
        } else {
            return false;
        }
    }

    public Node retornaNodoEsquerda(Node n) {
        return n.esquerda;
    }

    public Node retornaNodoDireita(Node n) {
        return n.direita;
    }
    
    public boolean temDoisFilhos(Node n){
        if(n.esquerda.verificaTexto(n)==true && n.direita.verificaTexto(n)==true){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean verificaPergunta(Node n){
        String aux = n.getTexto();
        if(aux.charAt(aux.length()-1)=='?'){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean verificaTexto(Node n){
        String aux = n.getTexto();
        if(aux.equalsIgnoreCase("")){
            return false;
        }
        else if(aux.equals(null)){
            return false;
        }
        else{
            return true;
        }
    }
    
    @Override
    public boolean equals(Object other) {
        if ((other instanceof Node) == false) {
            return false;
        }
        Node nother = (Node) other;
        return this.texto.equals(nother.getTexto());
    }
}
