package ru.dev.bolnik.dz1.animals;

public class Begemot extends Animal {
    private static final int maxRunning = 100;
    private static final int maxSwimming = 200;

    private static int counter = 0;

    public Begemot(String name) {
        super(name, maxSwimming, maxRunning);
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

}
