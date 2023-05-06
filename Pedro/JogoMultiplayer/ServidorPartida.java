package Pedro.JogoMultiplayer;

/**
 *
 * @author Breno
 */
public class ServidorPartida {
    
    String ip;
    int porta;
    int qtdSalas;

    public ServidorPartida(String ip, int porta, int qtdSalas) {
        this.ip = ip;
        this.porta = porta;
        this.qtdSalas = qtdSalas;
    }
    
    public void reservaPartida(){
        qtdSalas --;
    }
}

