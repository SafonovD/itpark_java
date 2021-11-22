package lesson_6;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciArray {
    public static void main(String[] args) {

        int[] arr = new int[1];
        boolean run = true;

        while (run) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите число мельше 45 или больше для выхода");
            int value = scanner.nextInt();

            if (value >= 46 | value < 0) {
                run = false;
            } else {
                int counterFib = fibMethod(value);
                if (serchFibValue(arr, counterFib) == counterFib) {
                    System.out.println("Число фибоначи " + counterFib + " по индексу " + value);
                } else {

                    arr = addArrayFibvalue(arr, counterFib);
                    for (int valueFib : arr) {
                        if (valueFib == counterFib) {
                            System.out.println("Число фибоначи " + valueFib + " по индексу " + value);
                        }
                    }

                }
            }
        }
        System.out.println("Выход");
        System.out.println(Arrays.toString(arr)); // смотрим массив из ряда фибоначи
    }

    public static int[] addArrayFibvalue(int[] arr, int counterFib) {

        arr = arrfib(arr, counterFib);
        return arr;
    }

    public static int serchFibValue(int[] arr, int counterFib) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == counterFib) {
                return counterFib;
            }
        }
        return -1;
    }

    public static int[] arrfib(int[] arr, int value) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = value;
                return arr;
            } else {
                int[] array = new int[arr.length + 1];
                System.arraycopy(arr, 0, array, 0, arr.length);
                for (int j = 0; j < array.length; j++) {
                    if (array[j] == 0 & array[j] != value) {
                        array[j] = value;
                        return array;
                    }
                }
            }
        }
        return arr;
    }

    public static int fibMethod(int value) {
        if (value == 0) {
            return 0;
        }
        if (value == 1) {
            return 1;
        } else {
            return fibMethod(value - 1) + fibMethod(value - 2);
        }
    }
}
