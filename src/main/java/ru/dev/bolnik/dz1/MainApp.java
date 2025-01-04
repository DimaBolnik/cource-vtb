package ru.dev.bolnik.dz1;

import ru.dev.bolnik.dz1.animals.Animal;
import ru.dev.bolnik.dz1.animals.Begemot;
import ru.dev.bolnik.dz1.animals.Cat;
import ru.dev.bolnik.dz1.animals.Dog;

public class MainApp {
    public static void main(String[] args) {
        Animal[] animals = {new Cat("Barsic"),
                new Begemot("Dick"), new Dog("Bobik")};

        for (Animal animal : animals) {
            animal.run(100);
            animal.swim(50);
        }

        System.out.println(Animal.getCounter());

    }
}
