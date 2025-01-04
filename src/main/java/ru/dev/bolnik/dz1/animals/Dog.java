package ru.dev.bolnik.dz1.animals;

public class Dog extends Animal {
    private static final int maxRunning = 500;
    private static final int maxSwimming = 10;

    private static int counter = 0;

    public Dog(String name) {
        super(name, maxSwimming, maxRunning);
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
