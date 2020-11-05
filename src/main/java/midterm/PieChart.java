package midterm;

import org.jfree.chart.*;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.*;
import java.util.Iterator;
import java.util.Map;

public class PieChart extends ApplicationFrame {

    public PieChart(String title, Map<String, Double> subjects) {
        super(title);
        setContentPane(createDemoPanel(subjects));
    }

    private static PieDataset createDataset(Map<String, Double> subjects) {
        DefaultPieDataset dataset = new DefaultPieDataset();

        for (Map.Entry<String, Double> entry : subjects.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }

        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {
        return ChartFactory.createPieChart("Pie Chart", dataset, true, true, false);
    }

    public static JPanel createDemoPanel(Map<String, Double> subjects) {
        JFreeChart chart = createChart(createDataset(subjects));
        return new ChartPanel(chart);
    }
}