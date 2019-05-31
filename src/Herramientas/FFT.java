/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herramientas;

import Objetos.Complejo;
import Objetos.ParOrdenado;
import java.util.ArrayList;

/**
 *
 * @author abam_
 */
public class FFT {
    
    
    Complejo[] armonicos,coef;
    
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
    public static String imprimir(Complejo[] c)
    {
        
        String retun="";
        for(int i = 0; i < c.length/2; i++)
        {
            retun+="Xn["+i+"]="+c[i].toRecString()+"\n";
            //System.out.println();
        }
        return retun;
    }
     public static Complejo[] fft(Complejo[]armonicos,boolean DIRECT) {

        int n = armonicos.length;
        double ld = Math.log(n) / Math.log(2.0);
       /* if (((int) ld) - ld != 0) {
            System.out.println("The number of elements is not a power of 2.");
            return null;
        }*/
        int nu = (int) ld;
        int n2 = n / 2;
        int nu1 = nu - 1;
        double[] xReal = new double[n];
        double[] xImag = new double[n];
        double tReal, tImag, p, arg, c, s;
        double constant;
        if (DIRECT)
            constant = -2 * Math.PI;
        else
            constant = 2 * Math.PI;
        for (int i = 0; i < n; i++) {
            xReal[i] = armonicos[i].getRe();
            xImag[i] = armonicos[i].getImg();
        }
        int k = 0;
        for (int l = 1; l <= nu; l++) {
            while (k < n) {
                for (int i = 1; i <= n2; i++) {
                    p = bitinversoReferencia(k >> nu1, nu);
                    arg = constant * p / n;
                    c = Math.cos(arg);
                    s = Math.sin(arg);
                    tReal = xReal[k + n2] * c + xImag[k + n2] * s;
                    tImag = xImag[k + n2] * c - xReal[k + n2] * s;
                    xReal[k + n2] = xReal[k] - tReal;
                    xImag[k + n2] = xImag[k] - tImag;
                    xReal[k] += tReal;
                    xImag[k] += tImag;
                    k++;
                }
                k += n2;
            }
            k = 0;
            nu1--;
            n2 /= 2;
        }
        k = 0;
        int r;
        while (k < n) {
            r = bitinversoReferencia(k, nu);
            if (r > k) {
                tReal = xReal[k];
                tImag = xImag[k];
                xReal[k] = xReal[r];
                xImag[k] = xImag[r];
                xReal[r] = tReal;
                xImag[r] = tImag;
            }
            k++;
        }
        Complejo[] cout = new Complejo[xReal.length*2];
        double radice = 1 / Math.sqrt(n);
        int j=0;
        for (int i = 0; i < cout.length; i += 2) {
            int i2 = i / 2;
            cout[j] = new Complejo( (float)(xReal[i2] * radice*2),(float)(xImag[i2] * radice*2));
            j++;

        }
        return cout;
    }

    private static int bitinversoReferencia(int j, int nu) {
        int j2;
        int j1 = j;
        int k = 0;
        for (int i = 1; i <= nu; i++) {
            j2 = j1 / 2;
            k = 2 * k + j1 - 2 * j2;
            j1 = j2;
        }
        return k;
    }
    public static ArrayList<ParOrdenado> arrays(Complejo[] s){
        ArrayList<ParOrdenado> a = new ArrayList<>();
        for (int i = 0; i < s.length/2; i++) {
            a.add(new ParOrdenado(i, Math.abs(s[i].getRe())+Math.abs(s[i].getImg())));
        }
        return a;
    }
}
