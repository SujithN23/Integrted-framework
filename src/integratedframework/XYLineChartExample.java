/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integratedframework;

/**
 *
 * @author pooja
 */
import java.io.DataInputStream;
import java.io.FileInputStream;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
/**
 * @author imssbora
 */
public class XYLineChartExample extends JFrame {
  private static final long serialVersionUID = 6294689542092367723L;

  public XYLineChartExample(String title) {
    super(title);

    // Create dataset
    XYDataset dataset = createDataset();

    // Create chart
    JFreeChart chart = ChartFactory.createXYLineChart(
        "Result",
        "Keyword",
        "Count",
        dataset,
        PlotOrientation.VERTICAL,
        true, true, false);

    // Create Panel
    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);
  }

  private XYDataset createDataset() {
      XYSeriesCollection dataset = new XYSeriesCollection();
      try
      {
    

    XYSeries series = new XYSeries("Result Analysis");
    FileInputStream fin=new FileInputStream("final.txt");
    DataInputStream din=new DataInputStream(fin);
    String sg=din.readLine();
    int i=0;
    while(sg!=null)
    {
     String sp[]=sg.split(" ");
     i++;
     if(sp[1].equals("null"))
     {
      series.add(0.0d,i);
     }
     else
     {
         
       series.add(i,Double.parseDouble(sp[0]));
     }
     sg=din.readLine();
    }
    

    //Add series to dataset
    dataset.addSeries(series);
    
    
      }
      catch(Exception ee) {System.out.println(ee);}
      return dataset;
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      XYLineChartExample example = new XYLineChartExample("Real time results");
      example.setSize(800, 400);
      example.setLocationRelativeTo(null);
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      example.setVisible(true);
    });
  }
}
