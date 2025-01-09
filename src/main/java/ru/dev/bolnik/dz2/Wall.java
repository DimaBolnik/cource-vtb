package ru.dev.bolnik.dz2;

import ru.dev.bolnik.dz2.participants.Contestant;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean contest(Contestant contestant) {
        if (contestant.jump(height)) {
            return true;
        } else {
            return false;
        }
    }
}
