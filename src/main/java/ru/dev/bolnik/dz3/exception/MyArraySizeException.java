package ru.dev.bolnik.dz3.exception;


public class MyArraySizeException extends RuntimeException {

    public MyArraySizeException() {
       super("Выход за пределы 4 на 4");
    }

}
