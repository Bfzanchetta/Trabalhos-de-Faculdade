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
public class Cliente{
       
    public static void main(String args[]){
        //Declara Scanner para o prompt de usuario na troca de mensagens//
        Scanner s = new Scanner(System.in);
        
        try {
            //Tenta conexao com o DNS para procurar os servers
            System.out.println("ESSA PORRA VAI DAR CERTO");
            Conexao consultaDNS = new Conexao("192.168.1.73", 50504);
            consultaDNS.envia("Consulta");
            String resposta = consultaDNS.recebe();
            System.out.println(resposta);
            
            System.out.println("Qual dos ips e porta voce quer conectar");
            String ipConectar = s.nextLine();
            int portaConectar = s.nextInt();
                    
            
            Conexao teste = new Conexao(ipConectar, portaConectar);
            while(true){
                System.out.println("Escreva a mensagem que deseja enviar:");
                String a = s.nextLine();
                teste.envia(a);
                System.out.println("Mensagem recebida:");
                System.out.println(teste.recebe());
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
