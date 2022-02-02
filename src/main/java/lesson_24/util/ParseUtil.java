package lesson_24.util;

import lesson_24.entity.Depart;
import lesson_24.entity.UserCard;
import org.hibernate.Session;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParseUtil {

    public static List<Depart> parseDepartCsv(String departsPaht) throws IOException {
        List<Depart> departs = new ArrayList<>();
        List<String> fileLines = Files.readAllLines(Paths.get(departsPaht), Charset.forName("windows-1251"));
        for (String fileLine : fileLines) {
            List<String> columnList = splitTexLine(fileLine);
            Depart depart = new Depart();
            depart.setDepartName(columnList.get(0));
            departs.add(depart);
        }
        return departs;
    }

    public static List<UserCard> parseUserCardsCsv(String filePaht, List<Depart> departs) throws IOException, ParseException {
        List<UserCard> userCards = new ArrayList<>();
        List<String> fileLines = Files.readAllLines(Paths.get(filePaht), Charset.forName("windows-1251"));

        for (String fileLine : fileLines) {
            List<String> columnList = splitTexLine(fileLine);
            UserCard userCard = new UserCard();

            for (Depart depart : departs) {
                if (depart.getId() == Long.parseLong(columnList.get(0))) {
                    userCard.setDepart(depart);
                    userCard.setFullName(columnList.get(1));
                    userCard.setCartNumber(Integer.parseInt(columnList.get(2)));
                    userCard.setRestSum(Double.parseDouble(columnList.get(3)));
                    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                    Date startDate = format.parse(columnList.get(4));
                    userCard.setStartDate(startDate);
                    Date stopDate = format.parse(columnList.get(5));
                    userCard.setStopDate(stopDate);
                    Date birthDate = format.parse(columnList.get(6));
                    userCard.setBirthDate(birthDate);
                    userCard.setTel(columnList.get(7));
                }
            }
            userCards.add(userCard);
        }
        return userCards;
    }

    public static ArrayList<String> splitTexLine(String fileLine) {
        String[] splitedText = fileLine.split(";");
        ArrayList<String> columnList = new ArrayList<>();
        for (String s : splitedText) {
            if (IsColumnPart(s)) {
                String lastText = columnList.get(columnList.size() - 1);
                columnList.set(columnList.size() - 1, lastText + "," + s);
            } else {
                columnList.add(s);
            }
        }
        return columnList;
    }

    private static boolean IsColumnPart(String text) {
        String trimText = text.trim();
        return trimText.indexOf(";") == trimText.lastIndexOf(";") && trimText.endsWith(";");
    }

}
