/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pedro.JogoMultiplayer;

/**
 *
 * @author Breno
 */
public class Jogador {
    
    private int HP;
    private int Dinheiro;

    public Jogador() {
    }

    public Jogador(int HP, int Dinheiro) {
        this.HP = HP;
        this.Dinheiro = Dinheiro;
    }
    
    public void inicializaJogador(){
        this.Dinheiro=1000;
        this.HP=9000;
    }
    
    public void aplicaDano(int dano){
        this.HP = this.HP - dano;
    }
    
    public void adicionaDinheiro(int dinheiro){
        this.Dinheiro = this.Dinheiro + dinheiro;
    }
    
}
