package ru.dev.bolnik.dz6;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    private static final int SIZE = 10_000_000;
    private static final int HALF_SIZE = SIZE / 2;
    private static float[] arr = new float[SIZE];

    public static void main(String[] args) throws InterruptedException {
        printCurrentTimeMillis1();
        printCurrentTimeMillis2();
    }

    private static void initializeArray() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
    }

    private static void calculate(float[] array, int startIndex) {
        for (int i = 0; i < array.length; i++) {
            int originalIndex = startIndex + i;
            array[i] = (float)(array[i] * Math.sin(0.2 + originalIndex / 5) * Math.cos(0.2 + originalIndex / 5) *
                               Math.cos(0.4 + originalIndex / 2));
        }
    }

    public static void printCurrentTimeMillis1() {
        initializeArray();
        long startTime = System.currentTimeMillis();
        calculate(arr, 0);
        System.out.println("Время выполнения метода 1: " + (System.currentTimeMillis() - startTime) + " мс");
    }

    public static void printCurrentTimeMillis2() throws InterruptedException {
        initializeArray();
        long startTime = System.currentTimeMillis();

        float[] a1 = Arrays.copyOfRange(arr, 0, HALF_SIZE);
        float[] a2 = Arrays.copyOfRange(arr, HALF_SIZE, SIZE);

        Thread thread1 = new Thread(() -> calculate(a1, 0));
        Thread thread2 = new Thread(() -> calculate(a2, HALF_SIZE));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.arraycopy(a1, 0, arr, 0, HALF_SIZE);
        System.arraycopy(a2, 0, arr, HALF_SIZE, HALF_SIZE);

        System.out.println("Время выполнения метода 2: " + (System.currentTimeMillis() - startTime) + " мс");
    }
}
