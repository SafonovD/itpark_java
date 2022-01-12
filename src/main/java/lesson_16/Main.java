package lesson_16;

import java.util.Random;
import java.util.stream.IntStream;

/*
1.Создать класс Logger, параметризуемый текстом сообщения и уровнем логирования (ERROR, WARN, INFO, DEBUG, TRACE).

 2. Реализовать в данном классе метод записи в файл, помещающий следующую информацию: <текущее время> <статус> <сообщение>

3. Создать три потока, каждый из которых создает сообщение, дополнив его информацией о наименовании/идентификаторе потока. Формат выводимой информации: <текущее время> <статус> <идентификатор> <сообщение>

4. Каждый поток пишет в файл со случайной периодичностью, но задержка должна составлять не более 5 секунд (т.е. поток после записи засыпает на случайно определенное время (но не более 5 секунд), после пробуждения - вновь пишет информацию в файл с сохранением уже имеющейся информации).

5. По истечении минуты работы программы, необходимо остановить работу потоков и вывести содержимое сформированного файла в консоль.
 */
public class Main {
    final static String FILE_PATH = "C:\\test\\log.txt";
    public static void main(String[] args) {


        IntStream.range(0,3).boxed().map(i -> {

            final EnumLog[] valuesLenght = EnumLog.values();
            Logger logger = new Logger(EnumLog.values()[new Random().nextInt(valuesLenght.length)], FILE_PATH);
            return new Thread(logger);
        }).forEach(Thread::start);



    }
}