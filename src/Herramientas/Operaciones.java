/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herramientas;

import Objetos.Complejo;

/**
 *
 * @author mijum
 */
public class Operaciones {
    
    
    public Complejo suma(Complejo z1, Complejo z2){
        Complejo res = new Complejo(0,0);
         res.setRe(z1.getRe()+z2.getRe());
         res.setImg(z1.getImg()+z2.getImg());
        return res;
    }
     public Complejo resta(Complejo z1, Complejo z2){
         Complejo res = new Complejo(0,0);
         res.setRe(z1.getRe()-z2.getRe());
         res.setImg(z1.getImg()-z2.getImg());
        return res;
    }
      public Complejo multiplicacion(Complejo z1, Complejo z2){
          Complejo res = new Complejo(0,0);
         res.setRe((z1.getRe() * z2.getRe()) + ((z1.getImg()*z2.getImg())*-1));
         res.setImg(
                 (z1.getRe() * z2.getImg()) + (z1.getImg()*z2.getRe())
         );
        return res;
    }
    public Complejo division(Complejo z1, Complejo z2){
        Complejo res = new Complejo(0,0);
        Complejo denominador, numerador;
        numerador = multiplicacion(z1,z2.conjugado());
        denominador = multiplicacion(z2,z2.conjugado());
       res.setRe(numerador.getRe()/denominador.getRe());
       res.setImg(numerador.getImg()/denominador.getRe());
        
        return res;
    }
}
