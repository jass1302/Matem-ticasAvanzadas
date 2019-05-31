package Herramientas;

import java.util.ArrayList;
import org.nfunk.jep.JEP;

public class rungeK {
    double x0;
    double y0;
    double condicionPaso;
    String funcion;
    Double k[];
    String f;
    public rungeK(double x, double y, double h, String F){
        this.x0 = x; this.y0 = y; this.condicionPaso=h; this.funcion=F;
        k = new Double[4];
        this.f = F;
    }
   
    public ArrayList calcK(double h){ //Función para obtener los K
            JEP objJEP = new JEP();
            objJEP.addStandardFunctions(); //FUNCIONES MATEMATICAS
            objJEP.addStandardConstants(); //CONSTANTES MATEMATICAS
            objJEP.setImplicitMul(true);
        ArrayList<Double[]> ka = new ArrayList<Double[]>();
        
        double aux10;

        for (double i = 0; i <= condicionPaso; i+=h) {
            
            // K1
                objJEP.addVariable("x", x0);
                objJEP.parseExpression(funcion);
                aux10=objJEP.getValue();
                objJEP.addVariable("y", y0);
                objJEP.parseExpression(funcion);
                k[0] = objJEP.getValue();
            // K2
                objJEP = new JEP();
                objJEP.addVariable("x", x0 + (0.5*i));
                objJEP.parseExpression(funcion);
                aux10=objJEP.getValue();
                objJEP.addVariable("y", y0 + (y0+((0.5*i)*k[0])));
                objJEP.parseExpression(funcion);
                k[1] = objJEP.getValue();
           // K3
           objJEP = new JEP();
               objJEP.addVariable("x", x0 + i);
               objJEP.parseExpression(funcion);
               aux10=objJEP.getValue();
               objJEP.addVariable("y", y0 + ((0.5*i)*k[1]));
               objJEP.parseExpression(funcion);
               k[2] = objJEP.getValue();
           // K4
           objJEP = new JEP();
               objJEP.addVariable("x", x0 + i);
               objJEP.parseExpression(funcion);
               aux10=objJEP.getValue();
               objJEP.addVariable("y", i*k[2]);
               objJEP.parseExpression(funcion);
               k[3] = objJEP.getValue();
//            k[0] = x0 * y0; System.out.println("k1 = "+k[0]);
//            k[1] = 2*(x0 + (0.5*i)) * (y0+((0.5*i)*k[0])); System.out.println("k2 = "+k[1]);
//            k[2] = 2*(x0 + (0.5*i)) * (y0+((0.5*i)*k[1])); System.out.println("k3 = "+k[2]);
//            k[3] = 2*(x0+i) * (y0 + (i*k[2])); System.out.println("k4 = "+k[3]);
//        
//       
        double aux = y0 + (0.16666666666*i) * (k[0] + (2*k[1]) + (2*k[2]) + k[3]);
        System.out.println("x: "+i);
        System.out.println("y1 = "+aux);
        Double ax[] = new Double[2];
        ax[0] = i;
        ax[1] = aux;
        ka.add(ax);
        }
        return ka;
    }
    
    
    
}
