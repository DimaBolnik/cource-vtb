package ru.dev.bolnik.dz5;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }

    public static void uniqueWords(String[] words) {
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
