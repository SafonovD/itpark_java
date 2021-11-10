package lesson_3;
import java.util.Scanner;

public class FactorialN {
    public static void main(String[] args) {
        int value;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число :");
        value = sc.nextInt();
        System.out.println("факториал числа " + value + " = " + resultFact(value));
    }

    public static int resultFact(int value) {
        if (value <= 1) {
            return 1;
        } else {
            return value * resultFact(value - 1);
        }
    }
}
