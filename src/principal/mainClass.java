package principal;

import GUI.Calculadora;
import GUI.DFT_GUI;
import GUI.FFT_GUI;
import GUI.GUI_HUB;
import GUI.ScatterPlot;
import GUI.SerieFourier;
import Herramientas.Fourier;
import Objetos.Complejo;
import Herramientas.Operaciones;
import Herramientas.rungeK;
import metodosIntegracion.Trapecio;



public class mainClass {
    public static void main(String[] args) {
    
//        double[] tiempo = {1,5,9,1,32};
//        String func = "x^2+x+1";
////        
            
        
//            Trapecio T = new Trapecio();
//            System.out.println(T.metodoT("-1", "1",func,"10000"));
//            Fourier F = new Fourier(5, -1, 3, func);
//            ScatterPlot plot = new ScatterPlot("Fourier", F.createGraph(100));
//            plot.pack();
//            plot.setVisible(true);
             //F.pruebaFX(100);
             
//             SerieFourier FGUI = new SerieFourier();
//             FGUI.setTitle("Series de Fourier");
//             FGUI.setVisible(true);
             
//                DFT_GUI A = new DFT_GUI();
//                A.setTitle("Transformada discreta de fourier");
//                A.setVisible(true);
//                FFT_GUI A = new FFT_GUI();
//                A.setTitle("Transformada rápida de fourier");
//                A.setVisible(true);

//                

            
        GUI_HUB vista = new GUI_HUB();
        vista.setVisible(true);       
        // CAMPO DE PRUEBAS --RUNGEKUTTA
//            
    }
    
    
}
