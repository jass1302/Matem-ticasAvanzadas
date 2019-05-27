package metodosIntegracion;

import org.nfunk.jep.JEP;


public class Riemann {
    
    public String metodoR(String inf1, String sup1,String fx, String part){  
        String rs =null;
        
            JEP fun = new JEP();
            fun.addStandardFunctions(); //FUNCIONES MATEMATICAS
            fun.addStandardConstants(); //CONSTANTES MATEMATICAS
            fun.setImplicitMul(true);
            
            fun.parseExpression(inf1);
            double inf = fun.getValue();
            
            fun.parseExpression(sup1);
            double sup = fun.getValue();
            
            int n = Integer.parseInt(part);
            
            double h = (sup-inf)/n;
            
            double x[] = new double [n+1];
            x[0]=inf;
            x[n]=sup;
            for (int i = 1; i < x.length-1; i++) {
                x[i]=x[0]+(i*h);
            }
            double fxi[] = new double [n+1];
            
            double m=0;
            
            for (int i = 0; i < x.length; i++) {
                fxi[i]=fun.addVariable("x", x[i]);
                fun.parseExpression(fx);
                fxi[i] = fun.getValue();
            }
            
            for (int i = 0; i < x.length; i++) {
                m=m+fxi[i];
            }
            m=h*m;
            
            rs= Double.toString(m);
            
            
       
        return rs;
    }
}
