package midterm;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.*;

import java.util.Map;

public class BarChart extends ApplicationFrame {

    public BarChart( String applicationTitle, Map<String, Double> subject) {
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

    private CategoryDataset createDataset(Map<String, Double> subjects) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

        for (Map.Entry<String, Double> entry : subjects.entrySet()) {
            dataset.addValue(entry.getValue(), entry.getKey(), entry.getKey());
        }

        return dataset;
    }
}