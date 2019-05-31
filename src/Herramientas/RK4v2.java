package Herramientas;

import java.text.DecimalFormat;
import java.util.ArrayList;
import org.nfunk.jep.JEP;


public class RK4v2{
    
    String type,h,x0,y0,xn,f;
    JEP jep;

    public RK4v2(String h, String x0, String y0, String xn, String f) {
        this.h = h;
        this.x0 = x0;
        this.y0 = y0;
        this.xn = xn;
        this.f = f;
    }
    
    
    
    public String imprimir(int N,double t[],double y[])
    {
        DecimalFormat df = new DecimalFormat("0.00");
        String aaaa="";
        for(int i = 0; i < N; i++)
        {

//            System.out.println(i+"    "+df.format(t[i])+"    "+y[i]);
            aaaa+=" "+i+"\t"+df.format(t[i])+"\t"+y[i]+"\n";
            
        }
        return aaaa;
    }
    public double evaluar(double x,double y,String funtion)
    {
        try {
            jep.addVariable("x",x);
            jep.addVariable("y",y);
            jep.parseExpression(funtion);
            return jep.getValue();
        } catch (Exception e) {
            return 0;

        }
    }
    public String rk4()
    {
        jep = new JEP();
        try {
            jep.parseExpression(this.h);
            double h = jep.getValue();
            jep.parseExpression(this.x0);
            double x0 = jep.getValue();
            jep.parseExpression(this.y0);
            double y0 = jep.getValue();
            jep.parseExpression(this.xn);
            double xn = jep.getValue();
            int N=(int)((xn-x0)/h)+1;

            double t[]=new double[N];
            double k[]=new double[4];
            double y[]=new double[N];
            y[0]=y0;
            t[0]=x0;

            String function = this.f;
            
            for(int i=0;i<N-1;i++)
            {
                t[i+1]=x0+((i+1)*h);
                k[0]=h*evaluar(t[i],y[i],function);
                k[1]=h*evaluar(t[i]+((0.5)*h),y[i]+((0.5)*k[0]),function);
                k[2]=h*evaluar(t[i]+((0.5)*h),y[i]+((0.5)*k[1]),function);
                k[3]=h*evaluar(t[i]+h,y[i]+k[2],function);
                double l=((k[0]+(2*k[1])+(2*k[2])+k[3]));
                double p=0.166666;
                y[i+1]=y[i]+(p*l);
                System.out.println("");

            }
            return imprimir(N,t,y);



        } catch (Exception e) {
            return "Error";

        }
    }
}

