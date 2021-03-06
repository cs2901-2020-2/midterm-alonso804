package midterm;

import java.util.Map;

public class Chart {
    PieChart pieChart;
    BarChart barChart;

    public Chart(String name, Map<String, Double> subjects) {
        pieChart = new PieChart(name, subjects);
        barChart = new BarChart(name, subjects);
    }

    public void generatePieChart() {
        pieChart.setSize(560, 367);
        pieChart.setVisible(true);
    }

    public void generateBarChart() {
        barChart.pack();
        barChart.setVisible(true);
    }
}
