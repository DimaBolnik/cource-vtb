package ru.dev.bolnik.lesson1;

public class MainApp {
    public static void main(String[] args) {
        Animals[] animals = {new Cat("Barsic"),
                new Begemot("Dick"), new Dog("Bobik")};

        for (Animals animal : animals) {
            animal.run(100);
            animal.swim(50);
        }

    }
}
