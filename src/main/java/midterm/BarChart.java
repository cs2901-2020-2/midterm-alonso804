package midterm;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.HashMap;
import java.util.Map;

public class BarChart extends ApplicationFrame {

    public BarChart( String applicationTitle, HashMap<String, Double> subject) {
        super( applicationTitle );
        JFreeChart barChart = ChartFactory.createBarChart(
                "Bar Chart",
                "Category",
                "Score",
                createDataset(subject),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
    }

    private CategoryDataset createDataset(HashMap<String, Double> subjects) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

        for (Map.Entry<String, Double> entry : subjects.entrySet()) {
            dataset.addValue(entry.getValue(), entry.getKey(), entry.getKey());
        }

        return dataset;
    }

    /*
    public static void main( String[ ] args ) {
        BarChart chart = new BarChart("Car Usage Statistics",
                "Which car do you like?");
        chart.pack( );
        chart.setVisible( true );
    }
     */
}