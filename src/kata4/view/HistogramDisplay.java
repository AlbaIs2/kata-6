
package kata4.view;
import java.awt.Container;
import java.awt.Dimension;
import kata4.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;


public class HistogramDisplay extends ApplicationFrame{
    private final Histogram <String> histogram ;
    
    public HistogramDisplay (Histogram<String> histogram){
        super("HISTOGRAMA");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }
    public void  execute(){
        setVisible(true);
    }
    private Container createPanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }
   

    private JFreeChart createChart (DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart(
                "HISTOGRAMA",
                "DOMINIO EMAIL",
                "nº DE EMAILS",
                dataSet,
                PlotOrientation.VERTICAL,
                true,
                rootPaneCheckingEnabled,
                rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for(String key :histogram.KeySet()){
            dataSet.addValue(histogram.get(key),"",key);
        }
        return dataSet;
        
    
    }
    
    
}