package io.github.akotu235.race.counter;

public class CounterFactory {
    public static Counter createCounter(int version, int initialValue) {
        switch (version) {
            case 2:
                return new CounterV2(initialValue);
            case 3:
                return new CounterV3(initialValue);
            default:
                return new CounterV1(initialValue);
        }
    }
}