package ru.geekbrains.Course_2.lesson2;

public class Main2 {
    public static void main(String[] args) {

        //System.out.println("args = [" + 2 + "]"); //
        String[][] temp = {
                {"1", "2", "3", "4"},
                {"11", "22", "33", "44"},
                {"111", "~222", "333", "444"},
                {"1111", "2222", "3333", "4444"},
        };

        int sum = 0;
        try {
            sum = sumStringArrayElements(temp, 4);
        } catch (MyArraySizeException e) {
            System.err.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println(e.getMessage());
            System.err.println(String.format("Not a integer in row [%d], col [%d], cell value = \"%s\"", e.getRow(), e.getCol(), temp[e.getRow()][e.getCol()]));
        }

        System.out.println("sum = " + sum);

        System.out.println("Programm is finished");
    }

    public static void checkArraySize(String[][] arr, int size) throws MyArraySizeException {
        if (arr[0].length != size || arr.length != size) {
            throw new MyArraySizeException();
        }
    }

    public static int sumStringArrayElements(String[][] arr, int size) throws MyArraySizeException, MyArrayDataException {
        checkArraySize(arr, size);
        int val;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    val = Integer.parseInt(arr[i][j]);
                    sum += val;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ooops", i, j);
                }
            }
        }
        return sum;
    }
}
