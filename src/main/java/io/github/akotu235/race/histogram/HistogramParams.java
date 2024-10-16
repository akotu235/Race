package io.github.akotu235.race.histogram;

public class HistogramParams {
    public final String name;
    public final int range;
    public final int bucketSize;
    public final double xAxisFactor;
    public final String xAxisName;


    public HistogramParams(String name, int range, int bucketSize, int xAxisFactor, String xAxisName) {
        this.name = name;
        this.range = range;
        this.bucketSize = bucketSize;
        this.xAxisFactor = xAxisFactor;
        this.xAxisName = xAxisName;
    }

    public String getName() {
        return name;
    }

    public int getRange() {
        return range;
    }

    public int getBucketSize() {
        return bucketSize;
    }

    public double getXAxisFactor() {
        return xAxisFactor;
    }

    public String getXAxisName() {
        return xAxisName;
    }
}
