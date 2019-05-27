package metodosIntegracion;

import org.nfunk.jep.JEP;

/**
 *
 * @author mijum
 */
public class Trapecio {

    public String metodoT(String inf1, String sup1,String fx, String part) {
        String rs =null;
        
        try{
            JEP objJEP = new JEP();
            objJEP.addStandardFunctions(); //FUNCIONES MATEMATICAS
            objJEP.addStandardConstants(); //CONSTANTES MATEMATICAS
            objJEP.setImplicitMul(true);
            
            objJEP.parseExpression(inf1);
            double inf = objJEP.getValue();
            
            objJEP.parseExpression(sup1);
            double sup = objJEP.getValue();
            
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
                fxi[i]=objJEP.addVariable("x", x[i]);
                objJEP.parseExpression(fx);
                fxi[i] = objJEP.getValue();
            }       
            double feax;
            for (int i = 0; i <= n; i++) {
                feax = 2 * fxi[i];
                m = m + feax;
            }
            m=m+fxi[0]+fxi[n];
            m=(h*m)/2;
            rs= Double.toString(m);
            
            
        }catch(Exception e){
            rs="Sintáxis incorrecta";
        }
        return rs;
        
    }
    
}
