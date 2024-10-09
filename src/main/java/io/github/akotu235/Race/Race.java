package io.github.akotu235.Race;
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

// Watek, ktory inkrementuje licznik 100.000.000 razy
class IThread extends Thread {

    // TODO
}

// Watek, ktory dekrementuje licznik 100.000.000 razy
class DThread extends Thread {

    // TODO
}

public class Race {
    public static void main(String[] args) {
        Counter cnt = new Counter(0);

        // TODO

        System.out.println("stan=" + cnt.value());
    }
}
