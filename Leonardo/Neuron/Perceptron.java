package teste;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.exp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Neuron {

    boolean treinamento = false;
    ArrayList<Double> x1 = new ArrayList<>();
    ArrayList<Double> x2 = new ArrayList<>();
    ArrayList<Double> x3 = new ArrayList<>();
    ArrayList<Double> w1 = new ArrayList<>();
    ArrayList<Double> w2 = new ArrayList<>();
    ArrayList<Double> w3 = new ArrayList<>();

    Double y = 0.0;

    ArrayList<Double> b = new ArrayList<>();
    ArrayList<Double> t = new ArrayList<>();

    public Neuron() {
    }

    public Neuron(ArrayList<Double> x) throws IOException {
        this.leEntrada();
    }

    public void leEntrada() throws FileNotFoundException, IOException {
        FileReader file = new FileReader("C:\\Users\\Breno\\Documents\\NetBeansProjects\\Teste\\src\\teste\\entrada.txt");
        BufferedReader lerArq = new BufferedReader(file);

        String linha = lerArq.readLine(); // lê a primeira linha

        int contador = 0;
        while (linha != null) {
            x1.add(contador, Double.parseDouble(linha.substring(0, 4)));
            x2.add(contador, Double.parseDouble(linha.substring(4, 9)));
            x3.add(contador, Double.parseDouble(linha.substring(9, 14)));
            t.add(contador, Double.parseDouble(linha.substring(14, linha.length())));
            contador++;
            linha = lerArq.readLine(); // lê da segunda até a última linha
        }
    }

    public void preencheVariaveis() {
        //Preenchendo o Array w com valores aleatorios entre 0 e 1
        for (int i = 0; i < 10; i++) {
            w1.add(i, Math.random());
            w2.add(i, Math.random());
            w3.add(i, Math.random());
        }

        //Preenchendo o Array de bias com valores aleatorios entre 0 e 0.2
        for (int i = 0; i < 10; i++) {
            b.add(i, Math.random() * 0.01);
        }
    }

    public void treinaNeuronio() {
        //inicializa erro, taxa de aprendizado(alfa) e variáveis de controle
        int count = 0;

        ArrayList<Double> resultado = new ArrayList<>();
        double erro = 0.0;
        double desejado = 1.0;
        double alfa = 0.1;

        while (count != 1000) {
            for (int i = 0; i < 10; i++) {
                resultado.add(i, (x1.get(i) * w1.get(i)) + (x2.get(i) * w2.get(i)) + (x3.get(i) * w3.get(i)) + b.get(i)) ;

                double retornoAtivacao = this.funcaoAtivacao(resultado.get(i));
                if (retornoAtivacao == t.get(i)) {
                    System.out.println("Neurônio Dispara!");    
                } 
                else if (retornoAtivacao != t.get(i)) {
                    double erroLocal = 0.0;
                    double temp = 0.0;
                    erroLocal = t.get(i) - retornoAtivacao;
                    System.out.println("Neurônio Não Dispara!");
                    System.out.println("Necessita atualizar pesos");
                    
                    for(int k=0; k<10; k++){
                        w1.add(k, w1.get(k) + (alfa*erroLocal*x1.get(k)));
                        w2.add(k, w2.get(k) + (alfa*erroLocal*x2.get(k)));
                        w3.add(k, w3.get(k) + (alfa*erroLocal*x3.get(k)));   
                    }   
                }
                erro = Math.abs(t.get(i) - resultado.get(i));
            }
            count++;
            System.out.println("Iteração = "+count);
        }
        treinamento = true;
        this.printaPesos();
    }

    public double funcaoAtivacao(double x) {
        double alfa = 0.3;
        double f = 1 / (1 + exp(-alfa * x));
        return f;
    }
    
    public void printaPesos(){
        System.out.println("Vetor Pesos 1:");
        for(int i=0; i<10; i++){
            System.out.println(w1.get(i));
        }
        System.out.println("Vetor Pesos 1:");
        for(int i=0; i<10; i++){
            System.out.println(w2.get(i));
        }
        System.out.println("Vetor Pesos 1:");
        for(int i=0; i<10; i++){
            System.out.println(w3.get(i));
        }
    }
}
