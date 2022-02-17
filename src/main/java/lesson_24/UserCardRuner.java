package lesson_24;

import lesson_24.entity.Depart;
import lesson_24.entity.UserCard;
import lesson_24.util.CardUserFill;
import lesson_24.util.ParseUtil;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class UserCardRuner {
    public static void main(String[] args) {
        CardUserFill cardUserFill = new CardUserFill();

        String userCardsPaht = "src/main/resources/cardsuser.csv";
        String departsPaht = "src/main/resources/deperts.csv";

        try {
            System.out.println("Создаем таблицы на основе csv и заполняем их ");
            List<Depart> departList = ParseUtil.parseDepartCsv(departsPaht);
            cardUserFill.addDeparts(departList);
            List<UserCard> userCardslist = ParseUtil.parseUserCardsCsv(userCardsPaht,departList);
            cardUserFill.addUsersCards(userCardslist, departList );
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        //удаление таблиц
//        cardUserFill.dropUserCardAndDepartIfExists();
    }
}
