package ru.dev.bolnik.dz1.animals;

public class Cat extends Animal {
    private static final int maxRunning = 200;
    private static final int maxSwimming = 0;

    private static int counter = 0;

    public Cat(String name) {
        super(name, maxSwimming, maxRunning);
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
