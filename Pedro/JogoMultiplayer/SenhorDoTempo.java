package Pedro.JogoMultiplayer;

/**
 *
 * @author Breno
 */
public class SenhorDoTempo {
    
    int NLoguinho;
    int NLOGAO;

    public SenhorDoTempo() {
    }

    public SenhorDoTempo(int NLoguinho, int NLOGAO) {
        this.NLoguinho = NLoguinho;
        this.NLOGAO = NLOGAO;
    }
    
    public void relogioDoUniverso(){
        for(int i=0; i<=100000; i++){
            if(i==100000){
                
                
            }
        }
    }
    
    public static void main(String[] args){
        SenhorDoTempo timeLord = new SenhorDoTempo(0,0);
        System.out.println("AQUI COMECA A PUTARIA");
        //Em uma aplicacao Distribuida, o senhorDoTempo vai ter que enviar de tempos em tempos uma mensagem com o valor
        //atualizado dos Relogios Logicos//
        while(true){
            timeLord.relogioDoUniverso();
            System.out.println("Tempo"+timeLord.NLoguinho);
        }
    }
}
