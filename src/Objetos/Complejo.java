package Objetos;

import java.util.ArrayList;

/**
 *
 * @author mijum
 */
public class Complejo {
    private double re;
    private double img;
    private double modulo;
    private double angulo;
    private float S;  
    private ArrayList<Double> raices;
    public Complejo(float r, float i){
        this.re = r;
        this.img = i;
        this.modulo = modulo();
        this.angulo = formaPolar();
        raices = new ArrayList();
    }
    
    public Complejo(double r,double thetha){
        this.modulo = r;
        this.angulo = thetha;
        polarToRec();
//        System.out.println("Modulo: "+this.modulo);
//        System.out.println("Angulo: "+this.angulo);
    }
    
    public Complejo conjugado(){
        return new Complejo(getRe(),getImg()*-1);
    }
    public float modulo(){
        return  (float) Math.sqrt(Math.pow(re, 2) + (Math.pow(img, 2))); 
    }
    public double formaPolar(){  // Creo que el nombre no sería del todo correcto, pero en teoría con esto ya están calculados todos los datos para mostrar el complejo en su forma trigonométrica,
                                 //pero supongo que las forma será un truco de la interfaz? Porque si pongo la operacion completa pues la va calcular :v
        //float cos = re/getModulo();
        //float sin = img/getModulo();
        //return this.angulo = Math.ceil(Math.toDegrees(Math.atan(sin/cos)));
        return this.angulo = Math.round(Math.toDegrees(Math.atan(this.img/this.re)));
    }
    public void nRaices(int k){
        double α; // Angulo de k-Raices 
        this.S = (float) Math.pow(modulo, 1/k);
        for (int i = 0; i < k; i++) {
          α = Math.toDegrees(((2*i*Math.PI)+Math.toRadians(this.angulo))/k);
          α = Math.ceil(α);
          
         raices.add(α);
        }
    }
    /**
     * @return the re
     */
    public double getRe() {
        return re;
    }

    /**
     * @return the img
     */
    public double getImg() {
        return img;
    }

    /**
     * @param re the re to set
     */
    public void setRe(double re) {
        this.re = re;
    }

    /**
     * @param img the img to set
     */
    public void setImg(double img) {
        this.img = img;
    }

    /**
     * @return the modulo
     */
    public double getModulo() {
        return modulo;
    }

    /**
     * @return the angulo
     */
    public double getAngulo() {
        return angulo;
    }
    
    public String toPolarString(){
        return ""+this.modulo+"(cos("+this.angulo+") + isen("+this.angulo+"))";
    }
    public String toRecString(){
        if(this.img>=0) return "("+this.re+" + "+this.img+"i)";
        else return "("+this.re+" "+this.img+"i)";
        
    }
    
    public void polarToRec(){
        this.re = (float) (this.modulo*Math.cos(Math.toRadians(this.angulo)));
        this.img = (float) (this.modulo*Math.sin(Math.toRadians(this.angulo)));
    }
    
}
