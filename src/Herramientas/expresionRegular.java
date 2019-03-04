package Herramientas;

import Objetos.Complejo;
/**
 *
 * @author mijum
 */
public class expresionRegular {
    Complejo z1 = new Complejo(0,0);
    Complejo z2 = new Complejo(0,0);
    public Complejo res;
    int reviso = -1;
    int neg = 0;
    
    public void operaciones(String entrada){
        z1.setRe(0);
        z1.setImg(0);
        z2.setRe(0);
        z2.setImg(0);
       String[] x = entrada.split(" ");
       String opc="";
       int aux=0;
       int c=0;
        for (String coso: x) {
            
            if (coso.charAt(0)=='(') {
                aux=1;
                neg=0;
                c++;
                System.out.println("Inicia c"+c);
            }
            if (coso.charAt(0)==')') {
                System.out.println("Termina C"+c);
                aux=0;
            }
            if (aux==1 && coso.charAt(0) == '-') {
                neg=1;
            }
            if (aux==0 && (coso.charAt(0) == '+' || coso.charAt(0) == '-' || coso.charAt(0) == '/' || coso.charAt(0) == '*' )) {
                opc=""+coso.charAt(0);
                System.out.println(opc);
            }
            if (aux==1) {
                if (coso.charAt(0) == 'i') {
                    int al = 1;
                    if (neg==1) {
                        al = -1;
                    }
                    if (c==1) {
                        z1.setImg(al);
                    }
                    else if(c==2){
                        z2.setImg(al);
                    }
                }else{
                 String z = ComplejoOReal(coso);
                if (reviso==0) {
                    if (c==1) {
                        z1.setRe(Float.parseFloat(z));
                    }
                    if (c==2) {
                        z2.setRe(Float.parseFloat(z));
                    }
                }
                else if (reviso ==1){
                    float img = Float.parseFloat(z);
                    if (neg==1) {
                        img = img*-1;
                    }
                    if (c==1) {
                        z1.setImg(img);
                    }
                    if (c==2) {
                        z2.setImg(img);
                    }
                }   
                }
            }            
        }
        
        Operar(opc);
    }
    private String ComplejoOReal(String w){
        String aux="";
        
        for (int j = 0; j < w.length(); j++) {
            if (esNumero(w.charAt(j))==true) {
                aux+=w.charAt(j);
            }
        }
        return aux;
    }
    
     private boolean esNumero(char caracter){
        if(caracter >= 48 && caracter <= 57){
            reviso = 0;
           return true;
       }
         if (caracter == 'i') {
             reviso = 1;
             System.out.println(reviso);
             System.out.println("IMAGINARIO");
         }else{
           reviso = -1;  
         }
         
       return false;
   }
     private void Operar(String opc){
         Operaciones op = new Operaciones();
          switch(opc.charAt(0)) {
        case '+':
            res = op.suma(z1, z2);
        break;
        case '-':
            res = op.resta(z1, z2);
        break;
        case '/':
            res = op.division(z1, z2);
            break;
        case '*':
            res = op.multiplicacion(z1, z2);
            break;
 }
     }    
}
