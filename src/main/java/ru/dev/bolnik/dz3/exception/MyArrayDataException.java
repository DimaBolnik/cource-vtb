package ru.dev.bolnik.dz3.exception;

public class MyArrayDataException extends RuntimeException {
    private int row;
    private int column;
    private Object value;

    public MyArrayDataException(int row, int column, Object[][] value) {
        super("В " + row + " строке; " + column + " колонке, лежит что-то не то!");
        this.row = row;
        this.column = column;
        this.value = value[row][column];
    }
}
