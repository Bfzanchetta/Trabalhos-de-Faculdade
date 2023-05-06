package Pedro.JogoMultiplayer;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DNS {
    
    public static ArrayList<ServidorPartida> servidoresDePartidas = new ArrayList<>();
    int prioridade = 20;

    public static String retornaStringComInfos(){
        String enviaString="";
        for(int i=0; i<servidoresDePartidas.size(); i++){
            enviaString = enviaString + servidoresDePartidas.get(i).ip+","+servidoresDePartidas.get(i).porta+","+servidoresDePartidas.get(i).qtdSalas+"**";
        }
        return enviaString;
    }
    
    /*public static void populaArray(){
        String a = "";
        int b=0;
        int c=0;
        for(int i=0; i<10; i++){
            a = a + "OI";
            b++;
            c++;
            servidoresDePartidas.add(new ServidorPartida(a,b,c));
        }  ESSA FUNCAO SOH SERVE PARA VER SE O CLIENTE TAVA RECEBENDO A LISTA CORRETA
    }*/  
    
    
    public static void main(String[] args) throws IOException {
        servidoresDePartidas = new ArrayList<>();
        int controleDeReplicas = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("Rodando dns"); 
        //populaArray();
        RecebedorRegistroPartida threaRecebedor = new RecebedorRegistroPartida();
        threaRecebedor.start();
        int ultimoEnviado=0;   //Esse vai ser usado para atualizar mais na frente//
        while(true){
            String a = s.nextLine();    // Le do Scanner o prompt do usuario
            if(a.equals("Replicar")){
                System.out.println("*&*&*&*&*&*&*&*&*&*&*&");
                System.out.println("Iniciando a Replicacao:");
                System.out.println("*&*&*&*&*&*&*&*&*&*&*&");
                String ipDesejado = s.nextLine();
                int portaDesejada = s.nextInt();
                Conexao teste = new Conexao(ipDesejado, portaDesejada);
                teste.envia("Comecando Copia");              //Para controlar o while da copia
                String enviaString = "";
                for(int i=0; i<servidoresDePartidas.size(); i++){
                    enviaString = enviaString + servidoresDePartidas.get(i).ip+","+servidoresDePartidas.get(i).porta+","+servidoresDePartidas.get(i).qtdSalas;
                    teste.envia(enviaString);
                    enviaString = "";
                }
                teste.envia("Fim da Lista");
                ultimoEnviado = servidoresDePartidas.size();
                System.out.println("Replicacao Completa");
                controleDeReplicas++;
            }
            else if(a.equals("Atualizar copia")){
                System.out.println("Comecando a atualizar");
                String nula = "";
                //Atualiza na Replica1
                Conexao atualiza = new Conexao("localhost", 50206);
                atualiza.envia("Atualizar");
                for(int i=ultimoEnviado; i<servidoresDePartidas.size();i++){
                    nula = nula + servidoresDePartidas.get(i).ip+","+servidoresDePartidas.get(i).porta+","+servidoresDePartidas.get(i).qtdSalas;
                    System.out.println("COMO DEBUGAR EH CHATO");
                    atualiza.envia(nula);
                    nula = "";
                }
                atualiza.envia("Fim da Atualizacao");
                atualiza.close();
                if(controleDeReplicas>0){
                    //atualiza na Replica2
                    
                }
                
                
                
                //atualizacopia;
            }
            else if(a.equals("Eleicao")){
                Conexao eleicao = new Conexao("localhost", 50500);
                eleicao.envia("Eleicao");
                eleicao.close();
                        
             
            }
        }
        
    }
}