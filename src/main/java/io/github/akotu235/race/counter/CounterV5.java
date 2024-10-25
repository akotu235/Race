package io.github.akotu235.race.counter;

public class CounterV5 implements Counter {
    private int _val;
    private final Semafor semafor;

    public CounterV5(int n) {
        _val = n;
        semafor = new Semafor();
    }

    @Override
    public void inc() {
        semafor.P();
        try {
            _val++;
        } finally {
            semafor.V();
        }
    }

    @Override
    public void dec() {
        semafor.P();
        try {
            _val--;
        } finally {
            semafor.V();
        }
    }

    @Override
    public int value() {
        semafor.P();
        try {
            return _val;
        } finally {
            semafor.V();
        }
    }
}


class Semafor {
    private boolean _stan = true;
    private int _czeka = 0;

    public Semafor() {
    }

    public synchronized void P() {
        _czeka++;
        while (!_stan) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        _czeka--;
        _stan = false;
    }

    public synchronized void V() {
        _stan = true;
        if (_czeka > 0) {
            notify();
        }
    }
}