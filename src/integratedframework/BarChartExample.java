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
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;  
  
public class BarChartExample extends JFrame {  
  
  private static final long serialVersionUID = 1L;  
  
  public BarChartExample(String appTitle) {  
    super(appTitle);  
  
    // Create Dataset  
    CategoryDataset dataset = createDataset();  
      
    //Create chart  
    JFreeChart chart=ChartFactory.createBarChart(  
        "Result Chart", //Chart Title  
        "Keyword", // Category axis  
        "Count", // Value axis  
        dataset,  
        PlotOrientation.VERTICAL,  
        true,true,false  
       );  
  
    ChartPanel panel=new ChartPanel(chart);  
    setContentPane(panel);  
  }  
  
  private CategoryDataset createDataset() {  
    DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
    try
    {
    FileInputStream fin=new FileInputStream("final.txt");
    DataInputStream din=new DataInputStream(fin);
    String sg=din.readLine();
    int i=0;
    while(sg!=null)
    {
     String sp[]=sg.split(" ");
     i++;
     if(sp[0].equals("null"))
     {
     }
     else
     {
         dataset.addValue(Integer.parseInt(sp[0]),sp[1],"Fixed");
     }
     sg=din.readLine();
    }
  
    }
    catch(Exception ee)
    {
      System.out.println(ee);
    }
  
    return dataset;  
  }  
  
  public static void main(String[] args) throws Exception {  
    SwingUtilities.invokeAndWait(()->{  
      BarChartExample example=new BarChartExample("Bar Chart Window");  
      example.setSize(800, 400);  
      example.setLocationRelativeTo(null);  
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
      example.setVisible(true);  
    });  
  }  
}  
