package Herramientas;
import GUI.ScatterPlot;
import Objetos.ParOrdenado;
import java.util.ArrayList;
import metodosIntegracion.Trapecio;

public class Fourier{

    private double limSum,limInf,limSup,dif;
    private String funcion;
    public Trapecio T;
    public int div;
    


    public Fourier(double limSum, double limInf, double limSup, String funcion,int div) {
        this.limSum = limSum;
        this.limInf = limInf;
        this.limSup = limSup;
        this.funcion = funcion;
        T = new Trapecio();
        dif = limSup-limInf;
        this.div = div;
      
    }
    
    public double integral(){
        return Double.parseDouble(T.metodoT(limInf+"", limSup+"",funcion,div+""));
    }
    
    public double aN(int n){
        return Double.parseDouble(T.metodoT(limInf+"", limSup+"","("+funcion+")*cos("+n+"*pi*x/"+limSup+")",div+""));
    }
    
    public double bN(int n){
        return Double.parseDouble(T.metodoT(limInf+"", limSup+"","("+funcion+")*sin("+n+"*pi*x/"+limSup+")",div+""));
    }
    
    public double evaluateFX(double xValue){
        
        double fx = integral()/2;
        for (int i = 1; i < limSum; i++) {
            fx+=(aN(i)*Math.cos(i*Math.PI*xValue/limSup))+(bN(i)*Math.sin(i*Math.PI*xValue/limSup));
        }
        System.out.println("f("+xValue+")= "+fx);
        return fx;
    }
    
    public String coeficientes(){
        String coef;
        double fx = integral()/limSup;
        coef = "a0 = "+fx+"\n";
        for (int i = 1; i < limSum+1; i++) {
            coef += "a"+i+" = "+aN(i)/limSup+"   b"+i+" = "+bN(i)/limSup+"\n";
        }
        return coef;
    }
    
    public void pruebaFX(double h,int div){
        double lim= limInf;
        for (int i = 0; i <= h; i++) {
            System.out.println(lim+"\t"+evaluateFX(lim));
            lim+=dif/h;
        }
    }
    
    public ArrayList<ParOrdenado> createGraph(double h){
        ArrayList<ParOrdenado> array = new ArrayList<>();
        ParOrdenado xd;
        double lim= limInf;
        for (int i = 0; i <= h; i++) {
            xd = new ParOrdenado(lim,evaluateFX(lim));
            array.add(xd);
            lim+=dif/h;
        }
        return array;
    }
}