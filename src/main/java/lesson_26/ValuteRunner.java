package lesson_26;

import lesson_26.service.ValuteFetcher;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan("lesson_26")
public class ValuteRunner {

    private static final String EXIT = "выход";

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ValuteRunner.class);
        final ValuteFetcher valuteFetcher = annotationConfigApplicationContext.getBean(ValuteFetcher.class);

        System.out.println("Введите код валюты, по которой хотите получить информацию");
        System.out.printf("или введите %s для завершения программы:\n", EXIT);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String text = scanner.nextLine();
            if (EXIT.equalsIgnoreCase(text)) {
                return;
            }
            if (StringUtils.isBlank(text)) {
                System.out.println("");
                continue;
            }
            valuteFetcher.getValuteByCode(text.toUpperCase()).ifPresentOrElse(
                    value -> {
                        System.out.printf("Текущий курс валюты %s равен %.2f руб.\n", text, value);
                        System.out.println("Для выхода из программы введите \"выход\" ");
                    },
                    () -> System.out.println("введен несуществующий код")
            );
        }
    }
}
