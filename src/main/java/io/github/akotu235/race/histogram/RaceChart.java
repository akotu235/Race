package io.github.akotu235.race.histogram;

import io.github.akotu235.race.RaceParams;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.statistics.HistogramDataset;

import java.awt.*;

public class RaceChart extends ApplicationFrame {
    private final JFreeChart histogram;

    public RaceChart(HistogramDataset dataset, HistogramParams histogramParams) {
        super("Histogram");

        // Tworzenie histogramu
        histogram = ChartFactory.createHistogram(
                "Histogram Wartości Zmiennej Counter po " + RaceParams.ITERATIONS + " Uruchomieniach Pętli",
                histogramParams.getXAxisName(),
                "Częstotliwość",
                dataset,
                PlotOrientation.VERTICAL,
                false, // legenda
                false, // tooltips
                false  // URLs
        );

        // Ustawienie niestandardowej osi X
        XYPlot plot = (XYPlot) histogram.getPlot();
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setTickUnit(new NumberTickUnit((double) histogramParams.getBucketSize() / histogramParams.getXAxisFactor()));
        xAxis.setRange((double) histogramParams.getRange() / 2 / histogramParams.getXAxisFactor() * (-1), (double) histogramParams.getRange() / 2 / histogramParams.getXAxisFactor());

        // Ustawienie koloru słupków
        XYBarRenderer renderer = new XYBarRenderer();
        renderer.setSeriesPaint(0, Color.decode("#E74C3C"));
        plot.setRenderer(renderer);

        // Tworzenie panelu wykresu
        ChartPanel chartPanel = new ChartPanel(histogram);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);
    }

    public JFreeChart getHistogram() {
        return histogram;
    }
}