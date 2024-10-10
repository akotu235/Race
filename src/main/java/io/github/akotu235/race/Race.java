package io.github.akotu235.race;
// Race.java
// Wyscig

class Counter {
    private int _val;

    public Counter(int n) {
        _val = n;
    }

    public void inc() {
        _val++;
    }

    public void dec() {
        _val--;
    }

    public int value() {
        return _val;
    }
}

class IThread extends Thread {
    private final Counter counter;

    IThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < RaceParams.RACE_LENGTH; i++) {
            counter.inc();
        }
    }
}

class DThread extends Thread {
    private final Counter counter;

    public DThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < RaceParams.RACE_LENGTH; i++) {
            counter.dec();
        }
    }
}

public class Race {
    public static void main(String[] args) throws InterruptedException {
        int numIterations = 100;

        for (int i = 0; i < numIterations; i++) {
            Counter cnt = new Counter(0);

            IThread iThread = new IThread(cnt);
            DThread dThread = new DThread(cnt);

            iThread.start();
            dThread.start();

            iThread.join();
            dThread.join();

            int finalValue = cnt.value();
            System.out.println("Iteracja: " + i + ": " + finalValue);
        }
    }
}