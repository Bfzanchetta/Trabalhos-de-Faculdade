package Leonardo.Neuron;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.exp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Breno Zanchetta
 */
public class Neuron {

    boolean treinamento = false;
    ArrayList<Double> x = new ArrayList<>(10);
    ArrayList<Double> w = new ArrayList<>(10);
    Double y = 0.0;
    ArrayList<Double> b = new ArrayList<>(10);

    public Neuron() {
    }

    public Neuron(ArrayList<Double> x) throws IOException {
        this.x = x;
        this.leEntrada();
    }

    public void leEntrada() throws FileNotFoundException, IOException {
        FileReader file = new FileReader("/home/breno/NetBeansProjects/Neuronio/src/neuronio/entrada.txt");
        BufferedReader lerArq = new BufferedReader(file);

        String linha = lerArq.readLine(); // lê a primeira linha

        ArrayList<String> x1 = new ArrayList<>();
        ArrayList<String> x2 = new ArrayList<>();
        ArrayList<String> x3 = new ArrayList<>();
        ArrayList<String> t = new ArrayList<>();

        while (linha != null) {
            x1.add((linha.substring(0, 4)));
            x2.add((linha.substring(4, 9)));
            x3.add((linha.substring(9, 14)));
            t.add((linha.substring(14, linha.length())));
            System.out.printf("%s\n", linha);
            linha = lerArq.readLine(); // lê da segunda até a última linha
        }
        System.out.println("" + file);
    }

    public void preencheVariaveis() {
        for (int i = 0; i < 10; i++) {
            x.add(Math.random() * 0.5);
            //System.out.println(x.get(i));
        }

        //Preenchendo o Array w com valores aleatorios entre 0 e 1
        for (int i = 0; i < 10; i++) {
            w.add(Math.random());
            //System.out.println(w.get(i));
        }

        //Preenchendo o Array de bias com valores aleatorios entre 0 e 0.2
        for (int i = 0; i < 10; i++) {
            b.add(Math.random() * 0.2);
            //System.out.println(b.get(i));
        }
    }
    
    public void treinaNeuronio() {
        int count = 0;
        //Preenchendo o Array x com valores de entrada

        double resultado = 0.0;
        double erro = 0.0;
        double desejado = 1.0;
        double alfa = 0.1;

        while (count != 1000) {
            for (int i = 0; i < w.size(); i++) {
                for (int j = 0; j < w.size(); j++) {
                    resultado += (x.get(j) * w.get(j)) + b.get(j);
                    //y.add(i, (x.get(j) * w.get(j)) + b.get(j));
                }
                //System.out.println("RESULTADO: "+ resultado);
                //Atualiza os pesos e os bias
                erro = Math.abs(desejado - resultado);
                //System.out.println("Erro eh: "+erro);
                for (int j = 0; j < 10; j++) {
                    w.add(i + 1, w.get(i) + (alfa * erro * x.get(j)));
                    b.add(i + 1, b.get(i) + alfa * erro);
                    alfa = alfa * 0.98;
                }
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("O peso numero " + i + " eh:" + w.get(i));
            }
            y = resultado * 0.9;
            count++;
            System.out.println(count + " interacao");
        }
        treinamento = true;
    }

    public void backPropagation(ArrayList lista) {
        //Esse metodo pega as saidas das n-1 camadas anteriores e aplica sobre forma de pesos
        this.w.removeAll(x);  //Remove em caso de ter varios items
        this.w = lista;
        //Passa a lista de pesos das saidas dos neuronios anteriores para os pesos desse novo neuronio
    }

    public double funcaoAtivacao(double x) {
        double alfa = 0.3;
        double f = 1 / (1 + exp(-alfa * x));
        return f;
    }
}
