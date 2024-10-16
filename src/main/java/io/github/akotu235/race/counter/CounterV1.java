package io.github.akotu235.race.counter;

public class CounterV1 implements Counter {
    private int _val;

    public CounterV1(int n) {
        _val = n;
    }

    @Override
    public void inc() {
        _val++;
    }

    @Override
    public void dec() {
        _val--;
    }

    @Override
    public int value() {
        return _val;
    }
}