/* tcpserver.c  DNS*/

#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <string.h>


char matrizIP[13][20];        //matriz que contem as strings de IPs
char matrizPorta[13][20];     //matriz que contem as portas correspondentes de cada IP
char numeroJogadores[20];	//numero de jogadores por cada partida
int indexAtual=0;		//index de controle de acesso as matrizes

char* procuraIP(){
	char stringRetorno[1024];
	int i=0;
	for(i=0; i<indexAtual; i++){
		strcat(stringRetorno, matrizIP[i]);   //Concatenacao das strings de IP//
		strcat(stringRetorno,"*");
	}
	return stringRetorno;
}

char* procuraNumero(char o){	
	char stringRetorno[1024];
	int i=0;	
	for(i=0; i<indexAtual; i++){
		if(numeroJogadores[i] == o){
			strcat(stringRetorno, matrizIP[i]);      //concatena e retorna//
			strcat(stringRetorno,"*");	
		}
	}
	return stringRetorno;
}

void armazenaIP(char* a, char* b, char c){		
	strcat(matrizIP[indexAtual],a);	
	strcat(matrizPorta[indexAtual],b);	
	numeroJogadores[indexAtual]=c;
	indexAtual++;
}

int main()
{
    while(1){        
	int x;	
	int sock, connected, bytes_recieved , teste = 1;  
        char recv_data[1024];
	char* send_data = (char*)malloc(100);       

        struct sockaddr_in server_addr,client_addr;    
        int sin_size;
        
        if ((sock = socket(AF_INET, SOCK_STREAM, 0)) == -1) {
            perror("Socket");
            exit(1);
        }

        if (setsockopt(sock,SOL_SOCKET,SO_REUSEADDR,&teste,sizeof(int)) == -1) {
            perror("Setsockopt");
            exit(1);
        }
        
        server_addr.sin_family = AF_INET;         
        server_addr.sin_port = htons(9005);     //Determinando a porta do DNS como fixa e de valor 9005
        server_addr.sin_addr.s_addr = INADDR_ANY; 
        bzero(&(server_addr.sin_zero),8); 

        if (bind(sock, (struct sockaddr *)&server_addr, sizeof(struct sockaddr))
                                                                       == -1) {
            perror("Unable to bind");
            exit(1);
        }

        if (listen(sock, 5) == -1) {
            perror("Listen");
            exit(1);
        }
		
	printf("\nDNS Server Waiting for client on port 9005");
        fflush(stdout);


        while(1)
        {  

            sin_size = sizeof(struct sockaddr_in);
	    
            connected = accept(sock, (struct sockaddr *)&client_addr,&sin_size);    //FALHA DE SEGMENTACAO AQUI//
            
            printf("\n I got a connection from (%s , %d)",
                   inet_ntoa(client_addr.sin_addr),ntohs(client_addr.sin_port));
            printf("%s",inet_ntoa(client_addr.sin_addr));  
	    
            
	    bytes_recieved = recv(connected,recv_data,1024,0);   
	
            recv_data[bytes_recieved] = '\0';   //erro esta antes dessa linha	
		//printf("%s",recv_data);

 

            	//Se a conexao do DNS nao for interrompida a string sera processada e a decisao tomada
            if(strcmp(recv_data , "IP")==0){      //procura o ip no banco de dados do DNS//
			send_data=procuraIP();    //Vai receber os IPs de servers prontos pro jogo
			send(sock, send_data, 1024 , 0); 
	    }
	    else if(strcmp(recv_data , "2p")==0){  //Procura os ips das partidas com 2 players//
			send_data=procuraNumero('2');
			send(sock, send_data, 1024 , 0);	    
			}
	    else if(strcmp(recv_data , "3p")==0){  //Procura os ips das partidas com 3 players//
			send_data=procuraNumero('3');
			send(sock, send_data, 1024 , 0);
	    }
	    else if(strcmp(recv_data , "4p")==0){  //Procura os ips das partidas com 4 players//
			send_data=procuraNumero('4');
			send(sock, send_data, 1024 , 0);
	    }
	    else if((recv_data == '2') || (recv_data== '3') || (recv_data=='4')){
			armazenaIP(inet_ntoa(client_addr.sin_addr),ntohs(client_addr.sin_port),recv_data);
			printf("\n IP adicionado ao banco de dados = %s " , recv_data);
            		fflush(stdout);
		
            		send_data="IP anotado";               
            		send(sock, send_data, 10, 0);
	    }
	    else{
			printf("\nMensagem nao reconhecida");
			send_data="Mensagem nao reconhecida"; 
			send(sock, send_data, 25 , 0);         
	    }	
               
      	//free(send_data);
           close(sock); 
	   break;
	}  

   
    }
	return 0;
}
