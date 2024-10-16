package io.github.akotu235.race.histogram;

import io.github.akotu235.race.RaceParams;

public class HistogramParamsFactory {
    public static HistogramParams createHistogramParams(int counterVersion) {
        switch (counterVersion) {
            case 2:
            case 3:
                return new HistogramParams(
                        "histogramV" + counterVersion,
                        5,
                        1,
                        1,
                        "Wartości"
                );
            default:
                return new HistogramParams(
                        "histogramV" + counterVersion,
                        RaceParams.RACE_LENGTH * 2,
                        RaceParams.RACE_LENGTH * 2 / 20,
                        1_000_000,
                        "Wartości (mln)"
                );
        }
    }
}