package ru.dev.bolnik.dz4;

import java.util.ArrayList;

public class Box<V extends Fruit> {

    private ArrayList<V> container = new ArrayList<>();

    public void add(V fruit) {
        container.add(fruit);
    }

    public ArrayList<V> getContainer() {
        return container;
    }

    public float getWeight() {
       if (container.isEmpty()) return 0;
       return container.size() * container.get(0).getWeight();
    }

    public boolean compare(Box<?> box) {
        return this.getWeight() == box.getWeight();
    }

    public void shifting(Box<V> box) {
        box.getContainer().addAll(container);
        container.clear();
    }
}
