package midterm;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PieChart extends ApplicationFrame {

    public PieChart(String title, HashMap<String, Double> subjects) {
        super(title);
        setContentPane(createDemoPanel(subjects));
    }

    private static PieDataset createDataset(HashMap<String, Double> subjects) {
        DefaultPieDataset dataset = new DefaultPieDataset();

        Iterator subjectIterator = subjects.entrySet().iterator();

        for (Map.Entry<String, Double> entry : subjects.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }

        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart("Pie Chart", dataset, true, true, false);

        return chart;
    }

    public static JPanel createDemoPanel(HashMap<String, Double> subjects) {
        JFreeChart chart = createChart(createDataset(subjects));
        return new ChartPanel(chart);
    }

    /*
    public static void main(String[] args) {
        PieChart demo = new PieChart("Mobile Sales");
        demo.setSize(560, 367);
        demo.setVisible(true);
    }

     */
}