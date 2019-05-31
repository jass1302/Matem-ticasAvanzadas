package Herramientas;

import Objetos.Complejo;
import Objetos.ParOrdenado;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class DFT {
    
    
    Complejo[] armonicos;
    Complejo[] c;
    



        //Meter el array de números separados por comas y retorna el array de complejos
    public static Complejo[] separar(String f)
    {
        String[]aux= f.split(",");
        Complejo[] F= new Complejo[aux.length];
        for(int i=0;i<aux.length;i++)
        {
            F[i]=new Complejo(Float.parseFloat(aux[i]),0f);
        }
            return F;
    }
    //Imprime el array de comlejos
    public static String imprimir(Complejo[] c)
    {
        String retun="";
        for(int i = 0; i < c.length; i++)
        {
            retun+="Xn["+i+"]="+c[i].toRecString()+"\n";   
        }
        return retun;
    }
    //Transformada
    public static Complejo[] dft(Complejo[] cinc) {

        int n = cinc.length;
        Complejo[] cout= new Complejo[n];
        for (int k = 0; k < n; k++) { 
            double sumreal = 0;
            double sumimag = 0;
            for (int t = 0; t < n; t++) { 
                double angle = 2 * Math.PI * t * k / n;
                sumreal +=  cinc[t].getRe()* Math.cos(angle) + cinc[t].getImg()* Math.sin(angle);
                sumimag += -cinc[t].getRe()* Math.sin(angle) + cinc[t].getImg()* Math.cos(angle);
            }
            
//            sumreal = Math.round((float)sumreal*1000f)/1000D;
//            sumimag = Math.round((float)sumimag*1000f)/1000D;
            
            
            cout[k] = new Complejo((float)sumreal,(float)sumimag);
        }
        return cout;
    }
    public static ArrayList<ParOrdenado> arrays(Complejo[] s){
        ArrayList<ParOrdenado> a = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            a.add(new ParOrdenado(i, Math.abs(s[i].getRe())+Math.abs(s[i].getImg())));
        }
        return a;
    }
}




