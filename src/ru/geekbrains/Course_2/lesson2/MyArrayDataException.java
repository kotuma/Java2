package ru.geekbrains.Course_2.lesson2;

public class MyArrayDataException extends Exception{
    private final int col;
    private final int row;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public MyArrayDataException(String message, int row, int col) {
        super(message + (message.endsWith(".")? "": ".") + String.format(" Error occurs in [%d][%d]", row, col));
        this.col = col;
        this.row = row;
    }
}
