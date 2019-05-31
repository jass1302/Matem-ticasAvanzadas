
package GUI;
import Objetos.ParOrdenado;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Grafica extends JFrame {
  private static final long serialVersionUID = 6294689542092367723L;

 

  public Grafica(String title,ArrayList<ParOrdenado> arraa) {
    super(title);
    XYSeries series = new XYSeries("Fourier");
    XYSeriesCollection dataset = new XYSeriesCollection();
    // Create dataset
   for(ParOrdenado O:arraa){
    series.add(O.x,O.y);
    }
    dataset.addSeries(series);
    

    // Create chart
    JFreeChart chart = ChartFactory.createScatterPlot(
        "Fourier", 
        "X-Axis", "Y-Axis", dataset);

    
    //Changes background color
    XYPlot plot = (XYPlot)chart.getPlot();
    plot.setBackgroundPaint(new Color(255,228,196));
    
   
    // Create Panel
    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);
  }
}

