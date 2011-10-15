/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UIcomponents;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
/**
 *
 * @author Computer
 */
public class Pie extends JFrame{
    private static final long serialVersionUID = 1L;
    
    public Pie(String applicationtitle,String charttitle){
        super(applicationtitle);
        PieDataset dataset = createDataSet();
        JFreeChart chart = createChart(dataset,charttitle);
        ChartPanel chpanel = new ChartPanel(chart);
        chpanel.setPreferredSize(new java.awt.Dimension(500,300));
        setContentPane(chpanel);
    }
    
    private PieDataset createDataSet(){
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("test1",29);
        data.setValue("test2",51);
        data.setValue("test3",20);
        return data;
    }
    
    private JFreeChart createChart(PieDataset d,String charttitle){
        JFreeChart chart = ChartFactory.createPieChart3D(charttitle, d, true, true, false);
        PiePlot3D plot = (PiePlot3D)chart.getPlot();
        plot.setStartAngle(300);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;
    }
};
class Main{
    public static void main(String args[]){
        Pie demo = new Pie("Test","pie chart test");
        demo.pack();
        demo.setVisible(true);
    }
}
