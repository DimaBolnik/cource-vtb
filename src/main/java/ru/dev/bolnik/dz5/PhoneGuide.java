package ru.dev.bolnik.dz5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PhoneGuide {

    private Map<String, HashSet<Integer>> phoneGuides;

    public PhoneGuide() {
        phoneGuides = new HashMap<>();
    }

    public void add(String name, Integer number) {
        if (!phoneGuides.containsKey(name)) {
            phoneGuides.put(name, new HashSet<>());
        }
        phoneGuides.get(name).add(number);
    }

    public HashSet<Integer> get(String name) {
        if (!phoneGuides.containsKey(name)) {
            System.out.println("No such phone guide");
        }
        return phoneGuides.get(name);
    }

}
