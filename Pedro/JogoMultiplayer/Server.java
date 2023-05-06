package Pedro.JogoMultiplayer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.ServerSocket;
import java.util.Scanner;
/**
 *
 * @author Breno
 */
public class Server {
      
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try {
            Conexao teste = new Conexao("192.168.1.73", 50504);
            
            
            teste.envia("192.168.1.94,50100,3");   //Informa o DNS que ele esta ali
            /*teste.close*/
            //Abrindo outra conexao para comunicacao Cliente-Servidor
            int porta = 50100;
            ServerSocket servidor = new ServerSocket(porta);   
            Conexao conexao = new Conexao(servidor.accept());
            while(true){    //Inicia comunicacao com Cliente
                System.out.println("Mensagem recebida:");
                System.out.println(conexao.recebe());
                System.out.println("Digite alguma mensagem para enviar:");
                String mensagem = s.nextLine();
                conexao.envia(mensagem);
            }
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
