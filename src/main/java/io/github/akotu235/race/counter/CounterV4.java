package io.github.akotu235.race.counter;

//https://artemis.wszib.edu.pl/~funika/pwir/tw/lab2/Race2.java
public class CounterV4 implements Counter {
    private int _val;

    public CounterV4(int n) {
        _val = n;
    }

    @Override
    public synchronized void inc() {
        int n;
        n = _val;
        n = n + 1;
        //Thread.yield(); // !!! wymuszenie zmiany kontekstu !!!
        _val = n;
    }

    @Override
    public synchronized void dec() {
        int n;
        n = _val;
        n = n - 1;
        _val = n;
    }

    @Override
    public int value() {
        return _val;
    }
}