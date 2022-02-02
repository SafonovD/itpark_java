package lesson_24;

import lesson_24.entity.Depart;
import lesson_24.entity.UserCard;
import lesson_24.util.CardUserFill;
import lesson_24.util.ParseUtil;


import java.io.IOException;

import java.text.ParseException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvRuner {
    public static void main(String[] args) {

        String userCardsPaht = "src/main/resources/cardsuser.csv";
        String departsPaht = "src/main/resources/deperts.csv";

        CardUserFill cardUserFill = new CardUserFill();

        try {
            List<Depart> departList = ParseUtil.parseDepartCsv(departsPaht);
            cardUserFill.addDeparts(departList);
            List<UserCard> userCardslist = ParseUtil.parseUserCardsCsv(userCardsPaht,departList);
            cardUserFill.addUsersCards(userCardslist, departList );
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

  // Вывод в консоль с базы данных из таблицы usercard
        List<UserCard> allUserCards = cardUserFill.getAllUserCards();
        Map<Depart, List<UserCard>> userCartMap = allUserCards.stream().collect(Collectors.groupingBy(UserCard::getDepart));

        userCartMap.forEach(((depart,userCarts)->{
            System.out.println(depart.getDepartName());
            userCarts.forEach(userCard -> System.out.println(userCard.getFullName()));
            System.out.println();

        }));

    }
}
