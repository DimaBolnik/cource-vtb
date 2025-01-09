package ru.dev.bolnik.dz3;

import ru.dev.bolnik.dz3.exception.MyArrayDataException;
import ru.dev.bolnik.dz3.exception.MyArraySizeException;

public class Main {
    public static void main(String[] args) {
        String[][] arr= {{"1","2","3","4","5"},{"5","6","7","8"},
                {"9","10","11","12"},{"13","14","15","16"}};

        calculate(arr);
    }
    public static void calculate(String[][] array) {
        int count=0;
        if (array.length !=4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    count += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j,array);
                }
            }
        }
        System.out.println(count);
    }
}
