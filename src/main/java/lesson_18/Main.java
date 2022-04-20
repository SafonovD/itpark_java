package lesson_18;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.atomic.AtomicInteger;

/*
1. Добавить поддержку Maven для проекта

2. Имеется в распоряжении текстовый файл, состоящий из  нескольких строк (можно расположить в папке с ресурсами
 или наполнить отдельным раннером). Необходимо в  отдельном потоке считывать его содержимое, перекладывая
 каждую строку в отдельный файл (количество создаваемых  файлов соответствует количеству строк в файле).

 */
public class Main {
    private static final String PATH_FILE = "/newfile.txt";

    public static void main(String[] args) throws IOException {
        System.out.println("считываем текстовый файл");
        try (BufferedReader bufferedReader = new BufferedReader
                (new InputStreamReader(Main.class.getResourceAsStream(PATH_FILE), StandardCharsets.UTF_8))) {
            final String extension = FilenameUtils.getExtension(PATH_FILE);
            AtomicInteger index = new AtomicInteger();
            bufferedReader.lines().filter(StringUtils::isNotBlank)
                    .forEach(line -> writeToNewFile(extension, index, line)
            );
        }
    }

    private static void writeToNewFile(String extension, AtomicInteger index, String line) {
        try {
            Path path = Paths.get("C:\\out", "result_" + (index.incrementAndGet()) + "." + extension);
            System.out.printf("Начало записи в файл %s\n", path.getFileName());
            Path pathParent = path.getParent();
          if(!Files.exists(pathParent)){
              if(!pathParent.toFile().mkdir()){
                  System.out.println("Ошибка при создание папки");
                  return;
              }
          }
            Files.writeString(path, line, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
