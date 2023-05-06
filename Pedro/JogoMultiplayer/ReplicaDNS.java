package Pedro.JogoMultiplayer;
import java.net.*;
import java.io.*;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Breno
 */
public class ReplicaDNS {
 
    public static ArrayList<ServidorPartida> servidoresReplicaDePartidas;
    int prioridade = 10;
    
    public void Atualizacao(){
        
    } 
    
    public static void main(String[] args) throws InterruptedException, IOException {
        servidoresReplicaDePartidas = new ArrayList<>();
        
        ServerSocket servidorDNSreplica = new ServerSocket(50200);   
        Conexao conexao = new Conexao(servidorDNSreplica.accept());
        
        System.out.println("Rodando copia do DNS");
        //Aqui ocorre a primeira atualizacao da Replica do DNS
        System.out.println("Agora atualizando o DNS-copia");
        String a = conexao.recebe();
        while(true){
            a = conexao.recebe();
            if(a.equals("Fim da Lista")){
                break;
            }
            String ip = a.split(",")[0];
            String b = a.split(",")[1];
            int c = Integer.parseInt(b);
            String d = a.split(",")[2];
            int e = Integer.parseInt(d);
            servidoresReplicaDePartidas.add(new ServidorPartida(ip,c,e));
            System.out.println("Ate agora o ip eh:"+ip+"a porta"+c+"e qtdade jogadores"+e);
        }
        //A partir desse ponto o DNS copia ja esta pronto, agora eh soh atualizar//
        conexao.close();
        System.out.println("A copia ja esta feita");
        System.out.println("*********************");
        System.out.println("Aguardando atualizacoes:");
        
        
        //A partir de agora a copia fica no prompt, caso queira pedir atualizacao//
        //Para tanto, deve-se abrir uma nova conexao//
        
        ServerSocket ServidorAtualizaDNS2 = new ServerSocket(50206);   
        Conexao atualiza = new Conexao(ServidorAtualizaDNS2.accept());
        String x = atualiza.recebe();
        if(x.equals("Atualizar")){
            System.out.println("TEM MACUMBA AQUI");
            while(true){
                a = atualiza.recebe();
                if(a.equals("Fim da Atualizacao")){
                    atualiza.close();
                    break;
                }
                String ip = a.split(",")[0];
                String b = a.split(",")[1];
                int c = Integer.parseInt(b);
                String d = a.split(",")[2];
                int e = Integer.parseInt(d);
                servidoresReplicaDePartidas.add(new ServidorPartida(ip,c,e));
                System.out.println("Ate agora o ip eh:"+ip+"a porta"+c+"e qtdade jogadores"+e);
            
                
            }
        }
        
        
        
        System.out.println("OPA LELELELELELELELE");
        ServerSocket eleicao = new ServerSocket(50500);   
        Conexao eleicaoLider = new Conexao(eleicao.accept());
        x = eleicaoLider.recebe();
        eleicaoLider.close();
        if(x.equals("Eleicao")){
            System.out.println("O vencedor da eleicao foi:");
                
        
            
        }
      
    }
}
