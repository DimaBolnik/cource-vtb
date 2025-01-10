package ru.dev.bolnik.dz4;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }

    public static <T> T[] replacingElements(T[] array, int indexA, int indexB) {
        T temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
        return array;
    }

    public static <T> ArrayList<T> convertArrayToArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }


}
