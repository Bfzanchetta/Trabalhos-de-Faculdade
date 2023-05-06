//Login//
#include <String.h>

int login(String user, String password);

void main(){
	if(login("Vanessa", "1234")==1){
		printf("Login realizado com sucesso);
	}
	else{
		printf("Erro no login);
	}
}

int login(String user, String password){
	char a[];
	char pwd[];
	char url[]="Senhas.txt";
	FILE *arq;
	
	printf("Escreva o seu usuario e senha");
	scanf("%s",&a);
	arq = fopen(url, "r");
	if(arq == NULL){
		printf("Erro, nao foi possivel abrir esse arquivo\n");
	}
	else{
		while((fscanf(arq,"%s %s\n", a, pwd))!=EOF){
			if(user==a){
				if(senha==pwd){
					return 1;
				}
			}
		}
	fclose(arq);
	return 0;
	}
}
