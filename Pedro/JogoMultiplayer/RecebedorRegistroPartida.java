package Pedro.JogoMultiplayer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Breno
 */
//protocolo ip,tipoJogo,qtdsalas

public class RecebedorRegistroPartida extends Thread{

    @Override
    public void run() {
        System.out.println("Rodando recebedor de recurso");
        try {
            ServerSocket recebedor = new ServerSocket(50504);
            while (true) {                
                Conexao conexao = new Conexao(recebedor.accept());
                String mensagem = conexao.recebe();
                if(mensagem.equals("Consulta")){
                    String possiveisConexoes = DNS.retornaStringComInfos();
                    conexao.envia(possiveisConexoes);
                    System.out.println("CONSULTA");
                    conexao.close();
                }
                else{
                    String ip = mensagem.split(",")[0];
                    String port = mensagem.split(",")[1];
                    int porta = Integer.parseInt(port);
                    int qtdSalas = Integer.parseInt(mensagem.split(",")[2]);
                    System.out.println("Recebeu recurso "+ip+" porta = "+porta+" qtd = "+qtdSalas);
                    DNS.servidoresDePartidas.add(new ServidorPartida(ip, porta, qtdSalas));
                    conexao.close();
                }
            }
        } catch (IOException ex) {
            System.out.println("Deu erro na abertura do socket, RecebedorRegistroPartidas");
            Logger.getLogger(RecebedorRegistroPartida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
