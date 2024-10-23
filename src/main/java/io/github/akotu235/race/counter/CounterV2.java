package io.github.akotu235.race.counter;

public class CounterV2 implements Counter {
    private int _val;

    public CounterV2(int n) {
        _val = n;
    }

    @Override
    public synchronized void inc() {
        _val++;
    }

    @Override
    public synchronized void dec() {
        _val--;
    }

    @Override
    public int value() {
        return _val;
    }
}