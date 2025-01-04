package ru.dev.bolnik.lesson1;

public class Begemot extends Animals {
    static int counter = 0;
    private static final int maxRunning = 100;
    private static final int maxSwimming = 200;

    public Begemot(String name) {
        super(name, maxSwimming, maxRunning);
        counter++;
    }

    @Override
    void run(int distance) {
        if (distance >= runningDistance) {
            System.out.println(name + ": пробежал " + distance + " м");
        } else System.out.println(name + ": не пробежал " + distance + " м");
    }

    @Override
    void swim(int distance) {
        if (distance >= swimmingDistance) {
            System.out.println(name + ": проплыл " + distance + " м");
        } else System.out.println(name + ": не проплыл " + distance + " м");
    }
}
