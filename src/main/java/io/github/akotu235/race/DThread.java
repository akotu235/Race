package io.github.akotu235.race;

import io.github.akotu235.race.counter.Counter;

class DThread extends Thread {
    private final Counter counter;

    public DThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < RaceParams.LENGTH; i++) {
            counter.dec();
        }
    }
}