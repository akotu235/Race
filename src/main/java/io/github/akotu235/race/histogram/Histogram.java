package io.github.akotu235.race.histogram;

import org.jfree.chart.ChartUtils;
import org.jfree.data.statistics.HistogramDataset;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Histogram {
    private final Map<Integer, Integer> data = new HashMap<>();
    private final HistogramParams histogramParams;

    public Histogram(HistogramParams histogramParams) {
        this.histogramParams = histogramParams;
    }

    public void put(int value) {
        int bucket = (int) Math.floor((double) value / histogramParams.getBucketSize()) * histogramParams.getBucketSize();
        data.put(bucket, data.getOrDefault(bucket, 0) + 1);
    }

    public void print() throws IOException {
        RaceChart chart = new RaceChart(getHistogramDataset(), histogramParams);

        // Zapis wykresu do pliku PNG
        File directory = new File("results");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        File file = new File("results/" + histogramParams.getName() + ".png");
        ChartUtils.saveChartAsPNG(file, chart.getHistogram(), 1000, 300);

        //Wyświetlenie wykresu
        chart.pack();
        chart.setVisible(true);
    }

    // Konwertowanie danych
    private HistogramDataset getHistogramDataset() {
        int totalEntries = data.values().stream().mapToInt(Integer::intValue).sum();
        double[] histogramData = new double[totalEntries];
        int index = 0;

        for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();

            for (int i = 0; i < count; i++) {
                histogramData[index++] = (double) value / histogramParams.getXAxisFactor();
            }
        }

        // Szukanie minimalnej i maksymalnej wartość w danych
        double minValue = Arrays.stream(histogramData).min().orElse(0);
        double maxValue = Arrays.stream(histogramData).max().orElse(0);

        // Obliczanie zakresu danych
        double range = (maxValue - minValue) * histogramParams.getXAxisFactor();

        // Obliczanie liczby przedziałów (bins)
        int binWidth = histogramParams.getBucketSize();
        int bins = (int) Math.ceil(range / binWidth);
        if (bins < 3) {
            bins = 3;
        }

        //Tworzenie datasetu
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("Histogram", histogramData, bins);

        return dataset;
    }
}