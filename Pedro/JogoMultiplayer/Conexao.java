package Pedro.JogoMultiplayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Hallan Neves
 */
public class Conexao {
    
    private Socket socket;
    private PrintWriter out;
    private BufferedReader input;
    
    
    public Conexao(Socket socket) throws IOException {
        this.socket = socket;
        out = new PrintWriter(socket.getOutputStream(), true);
        input =new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    
    public Conexao(String ip, int porta) throws IOException{
        this.socket = new Socket(ip, porta); 
        out = new PrintWriter(socket.getOutputStream(), true);
        input =new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    
    public void envia(Object obj){
        out.println(obj.toString());
    }
    
    public String recebe() throws IOException{
        return input.readLine();
    }

    public void close() throws IOException {
        socket.close();
    }
}
