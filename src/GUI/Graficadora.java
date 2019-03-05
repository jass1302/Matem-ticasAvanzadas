package GUI;

import Objetos.Complejo;
import java.util.ArrayList;
import org.jfree.data.xy.VectorSeries;
import org.jfree.data.xy.VectorSeriesCollection;
import org.jfree.chart.renderer.xy.VectorRenderer;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFrame;


public class Graficadora {

   VectorSeriesCollection dataSet;
   VectorSeries vectorSeries;
   XYPlot xyPlot;
   VectorRenderer r;
   JFreeChart Chart;

    public Graficadora() {
       
    }
    
    public void addVector(float x, float y){
        VectorSeriesCollection dataSet= new VectorSeriesCollection();
        VectorSeries vectorSeries=new VectorSeries("");
         vectorSeries.add(0, 0, x, y);
         dataSet.addSeries(vectorSeries);
         r = new VectorRenderer();
         xyPlot = new XYPlot(dataSet, new NumberAxis("Re Axis"), new NumberAxis("Im Axis"), r);
         Chart = new JFreeChart(xyPlot);
         //createFrame();
    }
    
    public void addVectors(ArrayList<Complejo> array){
        VectorSeriesCollection dataSet= new VectorSeriesCollection();
        VectorSeries vectorSeries=new VectorSeries("");
         
         for(Complejo c:array){
           vectorSeries.add(0,0,c.getRe(), c.getImg());
           System.out.println(c.toPolarString());
       }
         dataSet.addSeries(vectorSeries);
         r = new VectorRenderer();
         xyPlot = new XYPlot(dataSet, new NumberAxis("Re Axis"), new NumberAxis("Im Axis"), r);
         Chart = new JFreeChart(xyPlot);
         
    }
    
   
    
    
	
    
    public void createFrame(){
        ChartFrame frame = new ChartFrame("First", Chart);
        frame.pack();
        frame.setVisible(true);
    }
	
    

}
