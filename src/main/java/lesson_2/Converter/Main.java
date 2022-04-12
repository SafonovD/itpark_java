package lesson_2.Converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Distance distance = new Distance();
        Distance.Converter converter = new Distance.Converter();

        System.out.println("Введите 1  для Конвертации М в Км");
        System.out.println("Введите 2  для Конвертации Cм в М");
        System.out.println("Введите 3  для Конвертации М в См");
        int value = scanner.nextInt();



        switch (value) {
//            case (1) -> {
//                System.out.println("Введите длину");
//                value = scanner.nextInt();
//                converter.convertMToKm(value);
//                distance.print();
//            }
//            case (2) -> {
//                System.out.println("Введите длину");
//                value = scanner.nextInt();
//                converter.convertSmToDm(value);
//            }
//            case (3) -> {
//                System.out.println("Введите длину");
//                value = scanner.nextInt();
//                converter.convertMmToSm(value);
//                distance.print();
//            }
        }
    }
}
