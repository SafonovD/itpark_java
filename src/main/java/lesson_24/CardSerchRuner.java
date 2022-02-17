package lesson_24;

import lesson_24.entity.Depart;
import lesson_24.entity.UserCard;
import lesson_24.util.CardUserFill;


import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardSerchRuner {
    private final static String EXIT = "выход";

    public static void main(String[] args) {

        System.out.println("Введите номер карты владельца");
        System.out.printf("или введите %s для завершения работы программы:\n", EXIT);
        final Scanner scanner = new Scanner(System.in);
        CardUserFill cardUserFill = new CardUserFill();
        while (scanner.hasNext()) {
            final String text = scanner.nextLine();
            if (EXIT.equalsIgnoreCase(text)) {
                return;
            }
            UserCard userCard = cardUserFill.getUserCardByFullName(Integer.valueOf(text));
            System.out.println("--------------");
            if(userCard == null){
                System.out.println("ничего не найдено");
            }else {
                System.out.println(userCard.getFullName());
            }
        }
    }
}
