package lesson_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Опциональное практическое задание: Реализовать приложение, которое принимает на вход некоторый текст
(например, из консоли), вычисляет частоту появления слов в этом тексте и после чего выводит слова в убывающем
 порядке их частоты появления в тексте.

•Под словом подразумевается любая непрерывная последовательность символов (до пробела, точки, запятой, двоеточия и
других разделителей), состоящая только из букв и цифр, не учитывая регистр букв. Например, в строке "Семь раз отмерь,
1 раз отрежь!" ровно пять слов: "семь", "раз", "отмерь", "1", "отрежь" и вывод должен быть такой: Вывод для данного
случая такой:

•раз

•семь

•замерь

•1

•отрежь

Для решения необходимо пользоваться возможностями StreamAPI, избегая использования циклов и условных операторов.
Для примера можно взять такой текст:

Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam,
tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus
imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur
adipiscing elit. Integer vel odio nec mi tempor dignissim.
 */
public class Main {
    public static void main(String[] args) {

       String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam,\n" +
                   "tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus\n" +
                   "imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur\n" +
                   "adipiscing elit. Integer vel odio nec mi tempor dignissim.";

       String[] words = str.split(" ");
        List<String> wordList = (Arrays.asList(words));
  //     Arrays.stream(words).sorted(Comparator.comparingInt(String::length)).distinct().forEach(System.out::println);

        wordList.stream().sorted(Comparator.comparingInt(String::length)).distinct().forEach(System.out::println);

    }
}
