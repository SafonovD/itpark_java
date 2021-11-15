package lesson_5;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int value = scanner.nextInt();

        for (int i = 0; i < value; i++) {
            System.out.println(fibonacciMethod(i));
        }
    }

    public static int fibonacciMethod(int value) {

        if (value == 0) {
            return 0;
        }
        if (value == 1) {
            return 1;
        } else {
            return fibonacciMethod(value - 1) + fibonacciMethod(value - 2);
        }
    }
}
