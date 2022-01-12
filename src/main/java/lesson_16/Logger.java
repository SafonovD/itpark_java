package lesson_16;

import lombok.RequiredArgsConstructor;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@RequiredArgsConstructor
public class Logger implements Runnable {
    private final static String FORMAT_TEXT = "%s %s %s %s\n";
    private final static DateTimeFormatter FFULL_DATE = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss");

    private final EnumLog level;
    private final String s;
    private final long currentTimeMillis = System.currentTimeMillis();
    private int counter = 1;


    @Override
    public void run() {
        System.out.printf("\nПоток %s начал свою работу\n",Thread.currentThread().getName());
        while (System.currentTimeMillis() <= currentTimeMillis + 60 * 1000) {
            try (FileWriter fw = new FileWriter(s, true)) {
                fw.write(generateStringLog());
                Thread.sleep(new Random().nextInt(5_000));
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                break;
            }

        }

    }

    private String generateStringLog() {
        LocalDateTime nowTime = LocalDateTime.now();

        return String.format(FORMAT_TEXT, FFULL_DATE.format(nowTime),
                level,Thread.currentThread().getName(),"ЛОГ №" + counter++);
    }
}
