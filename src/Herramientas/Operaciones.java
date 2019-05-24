/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herramientas;

import Objetos.Complejo;
import java.util.ArrayList;

/**
 *
 * @author mijum
 */
public class Operaciones {
    
    public static ArrayList<Complejo>  nraices;

    public static ArrayList<Complejo> getNraices() {
        return nraices;
    }
    
    public static Complejo suma(Complejo z1, Complejo z2){
        Complejo res = new Complejo(0,0);
         res.setRe(z1.getRe()+z2.getRe());
         res.setImg(z1.getImg()+z2.getImg());
        return res;
    }
     public static Complejo resta(Complejo z1, Complejo z2){
         Complejo res = new Complejo(0,0);
         res.setRe(z1.getRe()-z2.getRe());
         res.setImg(z1.getImg()-z2.getImg());
        return res;
    }
      public static Complejo multiplicacion(Complejo z1, Complejo z2){
          Complejo res = new Complejo(0,0);
         res.setRe((z1.getRe() * z2.getRe()) + ((z1.getImg()*z2.getImg())*-1));
         res.setImg(
                 (z1.getRe() * z2.getImg()) + (z1.getImg()*z2.getRe())
         );
        return res;
    }
    public static Complejo division(Complejo z1, Complejo z2){
        Complejo res;// = new Complejo(0,0);
        /*Complejo denominador, numerador;
        numerador = multiplicacion(z1,z2.conjugado());
        denominador = multiplicacion(z2,z2.conjugado());
       res.setRe(numerador.getRe()/denominador.getRe());
       res.setImg(numerador.getImg()/denominador.getRe());*/
        res = new Complejo((double)(z1.getModulo()/z2.getModulo()),(double)(z1.getAngulo()-z2.getAngulo()));
        res.polarToRec();
        
        return res;
    }
    public static void raices(double n,Complejo z1){
        double r = Math.pow(z1.modulo(),1/n);
        double base=z1.formaPolar(),thetha;
        for (double i = 0; i < n; i++) {
            thetha = Math.round((base+(360*i))/n+Math.toDegrees(0.785398));
           
            Complejo complex = new Complejo(r,thetha);
            complex.polarToRec();
            //System.out.println(complex.toPolarString());
            nraices.add(complex);
            
        }
    }
    public static Complejo potencia(int n,double r,double thetha){
        //System.out.println(ans.getAngulo()+"  "+ans.getModulo());
        double newr = Math.pow(r, n);
        double newthetha = thetha*n;
        Complejo ans = new Complejo(newr,newthetha);
        return ans;
    }

    public Operaciones() {
        this.nraices = new ArrayList();
    }
}
