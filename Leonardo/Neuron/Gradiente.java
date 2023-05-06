package Leonardo.Neuron;
import static java.lang.Math.pow;
import java.math.*;
/**
 *
 * @author nautec
 */
public class Gradiente {
    
    double x, y;
    
    public double devolveResultado(double x, double y){
        double aux = 0.0;
        aux = pow((x-2.0),2);
        aux+= pow((y-3.0),2);
        aux+= Math.sin(x) * Math.cos(y);
        return aux;
    }
   
    public funcao derivaGradiente(double x, double y){
        funcao funcao = new funcao();
        função.recebe({[pow((x-2.0),2)] + [pow((y-3.0),2)] + [Math.sin(x) * Math.cos(y)]});
        funcao_linha = new funcao();
        função.derivada(funcao_linha);
        return funcao;
    }
}
