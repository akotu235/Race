package io.github.akotu235.race;

import io.github.akotu235.race.counter.Counter;
import io.github.akotu235.race.histogram.Histogram;

import java.util.Random;

public class RaceThread extends Thread {
    private final Counter cnt;
    private final Histogram histogram;

    public RaceThread(Counter cnt, Histogram histogram) {
        this.cnt = cnt;
        this.histogram = histogram;
    }

    @Override
    public void run() {
        IThread iThread = new IThread(cnt);
        DThread dThread = new DThread(cnt);

        Random random = new Random();
        if (random.nextBoolean()) {
            iThread.start();
            dThread.start();
        } else {
            dThread.start();
            iThread.start();
        }

        try {
            iThread.join();
            dThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        int finalValue = cnt.value();
        histogram.put(finalValue);
        System.out.println(finalValue);
    }
}