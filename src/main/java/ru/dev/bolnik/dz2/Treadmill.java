package ru.dev.bolnik.dz2;

import ru.dev.bolnik.dz2.participants.Contestant;

public class Treadmill implements Obstacle {
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }


    @Override
    public boolean contest(Contestant contestant) {
        if (contestant.run(length)) {
            return true;
        } else {
            return false;
        }
    }
}
