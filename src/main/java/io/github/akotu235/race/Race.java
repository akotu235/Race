package io.github.akotu235.race;

import io.github.akotu235.race.counter.Counter;
import io.github.akotu235.race.counter.CounterFactory;
import io.github.akotu235.race.histogram.Histogram;
import io.github.akotu235.race.histogram.HistogramParamsFactory;

import java.io.IOException;

public class Race {
    public static void main(String[] args) throws InterruptedException, IOException {
        int counterVersion = 1;
        if (args.length != 0) {
            counterVersion = Integer.parseInt(args[0]);
        }

        Histogram histogram = new Histogram(HistogramParamsFactory.createHistogramParams(counterVersion));

        Thread[] threads = new Thread[RaceParams.PROCES_COUNT];

        for (int i = 0; i < RaceParams.PROCES_COUNT; i++) {
            Counter cnt = CounterFactory.createCounter(counterVersion, 0);
            threads[i] = new RaceThread(cnt, histogram);
            threads[i].start();

            if (!RaceParams.EXECUTE_PARALLEL) {
                threads[i].join();
            }
        }

        if (RaceParams.EXECUTE_PARALLEL) {
            for (Thread thread : threads) {
                thread.join();
            }
        }

        histogram.print();
    }
}