package ru.dev.bolnik.dz2;

import ru.dev.bolnik.dz2.participants.Contestant;
import ru.dev.bolnik.dz2.participants.Cat;
import ru.dev.bolnik.dz2.participants.Human;
import ru.dev.bolnik.dz2.participants.Robot;

public class Main {
    public static void main(String[] args) {
        Contestant[] contestants = {new Cat("кот Вася", 100, 2),
                new Human("человек Борис", 200, 1),
                new Robot("робот Бендер", 300, 0)};

        Obstacle[] obstacles = {new Treadmill(100), new Wall(2)};

        for (Contestant contestant : contestants) {
            for (Obstacle obstacle : obstacles) {
                if(!obstacle.contest(contestant)) break;
            }
        }
    }
}
