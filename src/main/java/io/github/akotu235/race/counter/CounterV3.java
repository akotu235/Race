package io.github.akotu235.race.counter;

public class CounterV3 implements Counter {
    private int _val;
    private final Clock clock;
    private static final int INC_SLOT = 0;
    private static final int DEC_SLOT = 1;

    public CounterV3(int n) {
        this._val = n;
        this.clock = new Clock(200);
        clock.start();
    }

    @Override
    public void inc() {
        while (true) {
            if (clock.isActiveSlot(INC_SLOT)) {
                int tickId = clock.getTickId();
                int counter = _val + 1;
                if (tickId == clock.getTickId()) {
                    _val = counter;
                    break;
                }
            } else {
                sleep();
            }
        }
    }

    @Override
    public void dec() {
        while (true) {
            if (clock.isActiveSlot(DEC_SLOT)) {
                int tickId = clock.getTickId();
                int counter = _val - 1;
                if (tickId == clock.getTickId()) {
                    _val = counter;
                    break;
                }
            } else {
                sleep();
            }
        }
    }

    @Override
    public int value() {
        return _val;
    }

    private void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


class Clock extends Thread {
    private final int timeSlice;
    private int currentSlot;
    private int tickId;

    public Clock(int timeSlice) {
        this.timeSlice = timeSlice;
        this.currentSlot = 0;
        this.tickId = 0;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(timeSlice);
                tickId++;
                currentSlot = (currentSlot + 1) % 2;
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    boolean isActiveSlot(int slot) {
        return currentSlot == slot;
    }

    int getTickId() {
        return tickId;
    }
}