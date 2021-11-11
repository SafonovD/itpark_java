package lesson_4;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число");
        double value;
        value = sc.nextDouble();

        double num;
        double result = value / 2;

        do {
            num = result;
            result = (num + (value / num)) / 2;
        }
        while ((num - result) != 0);

        System.out.println("Результат вычисления :" + result);
    }
}
