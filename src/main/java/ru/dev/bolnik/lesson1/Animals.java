package ru.dev.bolnik.lesson1;

public abstract class Animals {
    protected String name;
    protected int swimmingDistance;
    protected int runningDistance;

    static int counter = 0;

    public Animals(String name, int swimmingDistance, int runningDistance) {
        this.name = name;
        this.swimmingDistance = swimmingDistance;
        this.runningDistance = runningDistance;
        counter++;
    }

    abstract void run(int distance);
    abstract void swim(int distance);
}
