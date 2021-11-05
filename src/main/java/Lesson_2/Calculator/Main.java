package Lesson_2.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число");
        int value1 = scanner.nextInt();
        System.out.println("Введите второе число");
        int value2 = scanner.nextInt();
        Calculator calculator = new Calculator();

        System.out.println("введите действие * / - +");
        String str = scanner.next();

        switch (str) {
            case ("*") -> System.out.println(calculator.multiplication(value1, value2));
            case ("/") -> System.out.println(calculator.division(value1, value2));
            case ("-") -> System.out.println(calculator.subtraction(value1, value2));
            case ("+") -> System.out.println(calculator.addition(value1, value2));
            default -> System.out.println("Нет такого знака");
        }
    }
}

class Calculator {

    public double multiplication(double value1, double value2) {
        return value1 * value2;
    }

    public double division(double value1, double value2) {

        if (value2 == 0) {
            throw new ArithmeticException("Деление на 0 не допустимо");
        }
        return value1 / value2;
    }

    public double subtraction(double value1, double value2) {
        return value1 - value2;
    }

    public double addition(double value1, double value2) {
        return value1 + value2;
    }
}

