package io.github.akotu235.race;

import io.github.akotu235.race.counter.Counter;

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