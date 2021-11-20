package lesson_6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MyArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину массива :");
        int lenghtValue = scanner.nextInt();

        int[] arr = new int[lenghtValue];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.println("-------------------");
        System.out.println(Arrays.toString(arr));
        System.out.println("-------------------");
        System.out.println("Максимальное значение массива : " + maxValue(arr));
        System.out.println("Минимальное значение массива : " + minValue(arr));
        System.out.println("среднее значение массива : " + avgValue(arr));
    }

    public static int maxValue(int[] arr) {
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    public static int minValue(int[] arr) {
        int minValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (minValue > arr[i]) {
                minValue = arr[i];
            }
        }
        return minValue;
    }

    public static int avgValue(int[] arr) {
        int avgValue = 0;
        for (int i = 0; i < arr.length; i++) {
            avgValue += arr[i];
        }
        return avgValue / arr.length;
    }
}
