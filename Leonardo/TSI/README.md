
Trabalho final de Topicos de Sistemas Inteligentes (01/2016)
Breno Fanchiotti Zanchetta - 51777
------------------------------------------------------------------------------------------

# 1. Introducao #
	O trabalho tem como base uma I.A. simulada, que pode ser treinada exaustivamente para o proposito de adivinhar o animal que o usuario esta pensando. No inicio da execucao, temos apenas uma pergunta e uma resposta, com base no animal que o usuario esta pensando, responde-se positivamente ou negativamente, e vai-se assim preenchendo a estrutura de dados.

# 2. Desenvolvimento #
	Para esse trabalho optei por usar a arvore binaria, com a classe Nodo como primitiva mais simples. Cada nodo possui como atributos: uma String texto que pode ser uma pergunta ou resposta, uma referencia para o Nodo da esquerda e uma referencia para nodo da Direita.
Por definicao de projeto, o branch da direita repesenta as respostas SIM, enquano a esquerda representa o NAO. Isso tornou possivel percorrer de forma organizada os branchs e analisar as respostas com base no input do usuario.
	A logica é simples: Se eu soh tenho uma pergunta e uma resposta no meu sub-branch da direita, eu disparo a pergunta e vejo a reacao do usuario: se ele responder positivamente eu respondo mandando a resposta do sub-branch da direita sobre forma de pergunta, i,e: Eu pego a resposta Gato e transformo em "ele eh um gato"?
Utilizando-me de logica combinacional de 4 niveis de profundidade consegui acertar os casos mais simples ate que o problema fosse solucionado. A arvore armazena corretamente e se reorganiza de forma otima caso o animal nao seja acertado.
	O maior problema desse trabalho foi a utilizacao do Framework JFrame do Java Netbeans IDE, que apresenta varios problemas de segmentacao e alguns bugs quanto ao numero de clicks. Pode-se notar por exemplo, que para iniciar a aplicacao, deve-se clicar duas vezes em iniciar, apesar de que isso nao condiz com a implementacao desse trabalho. Incapaz de responder o porque dessa anomalia ocorrer, continuei implementando e apenas desconsiderei o problema acima citado. 

# 3. Conclusao #
	Claro que o trabalho ainda se apresenta sobre uma forma muito embrionaria e tem muito que pode ser evoluido, e.g. Posso armazenar a arvore binaria sobre forma de um .txt ao final da execucao para que quando o usuario decida fechar a aplicacao e abrir denovo, ele possa ter a mesma sequencia de perguntas sem precisar digitar tudo novamente. Alem disso, alguns bugs de execucao apareceram de forma inesperada e podem ser resolvidos em uma nova versao do algoritmo. Alem disso, adicionar musica, melhores graficos e ate uma interface mais agradavel ao usuario pode ser feito sem muito custo adicional.

# 4. Agradecimentos #
	Gostaria de deixar o espaco final desse trabalho parar agradecer a voce, professor Leonardo que me auxiliou durante a graduacao, dando dicas e sendo extremamente flexivel com a entrega de projetos, sempre tendo em vista que os alunos tem varias tarefas para entregar e os prazos sao absurdos. Um muito obrigado, espero poder continuar contando com as suas ideias e contribuicoes no segundo semestre de 2016. Finalmente, digite IDDQD na opcao Carregar, deixei um EASTER EGG para o senhor. Abracos.

Para executar o código, basta ter um JavaEE8 instalado na sua máquina e configurado na variável de ambiente $PATH do seu sistema, para windows basta abrir o prompt de comando na pasta que contém o TrabalhoDoLeonardo.jar e executar o comando abaixo:

java -jar "TrabalhoDoLeonardo.jar" 

