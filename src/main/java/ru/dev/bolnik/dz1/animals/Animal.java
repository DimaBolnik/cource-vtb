package ru.dev.bolnik.dz1.animals;

public class Animal {
    protected String name;
    protected int maxSwimming;
    protected int maxRunning;

    private static int counter = 0;

    public Animal(String name, int maxSwimming, int maxRunning) {
        this.name = name;
        this.maxSwimming = maxSwimming;
        this.maxRunning = maxRunning;
        counter++;
    }

    public void run(int distance) {
        if (distance <= maxRunning) {
            System.out.println(name + ": пробежал " + distance + " м");
        } else System.out.println(name + ": не пробежал " + distance + " м");
    }

    public void swim(int distance) {
        if (distance <= maxSwimming) {
            System.out.println(name + ": проплыл " + distance + " м");
        } else System.out.println(name + ": не проплыл " + distance + " м");
    }

    public static int getCounter() {
        return counter;
    }
}
