package ru.dev.bolnik.dz2;

import ru.dev.bolnik.dz2.participants.Contestant;

public interface Obstacle {
    boolean contest(Contestant contestant);
}
