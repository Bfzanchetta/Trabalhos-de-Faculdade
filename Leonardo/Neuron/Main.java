package neuronio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Neuron neuronio1 = new Neuron();
        neuronio1.treinaNeuronio();
        neuronio1.leEntrada();
        
        Neuron neuronio2 = new Neuron();
        neuronio2.treinaNeuronio();
        neuronio2.leEntrada();
        
        Neuron neuronio3 = new Neuron();
        neuronio3.treinaNeuronio();
        neuronio3.leEntrada();
        
        Neuron neuronio4 = new Neuron();
        neuronio4.treinaNeuronio();
        neuronio4.leEntrada();
        
        Neuron neuronio5 = new Neuron();
        neuronio5.treinaNeuronio();
        neuronio5.leEntrada();
        
        System.out.println("As saídas da primeira iteração: "+neuronio1.w.get(0)+neuronio2.w.get(0)+neuronio3.w.get(0)+neuronio4.w.get(0)+neuronio5.w.get(0));
        
        ArrayList<Double> entradasIntermediarias = new ArrayList<>();
        
        entradasIntermediarias.add(neuronio1.w.get(0));
        entradasIntermediarias.add(neuronio2.w.get(0));
        entradasIntermediarias.add(neuronio3.w.get(0));
        entradasIntermediarias.add(neuronio4.w.get(0));
        entradasIntermediarias.add(neuronio5.w.get(0));
        while(true){
            
            if(false){
                break;
            }
        }
        Neuron intermediario1 = new Neuron(entradasIntermediarias);
        intermediario1.treinaNeuronio();
        System.out.println("Saída da primeira camada intermediária = "+ intermediario1.w);
        System.out.println("Saída que deveria ser = "+intermediario1.y);
        
    }
    
}
