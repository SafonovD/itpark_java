package lesson_10;

import lesson_10.convert.EuroConversion;
import lesson_10.convert.JpyConversion;
import lesson_10.convert.RubConversion;
import lesson_10.convert.UsdConversion;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Конвертер валют");
        System.out.println("1-USD,2-RUB,3-EUR,4-JPY");
        System.out.println("Введите число: Какую валюту хотите обменять");

        while (!scanner.hasNextInt()) {
            String str = scanner.next();
            System.out.println("вы ввели " + str + " введите число");
        }
        int currencyIn = scanner.nextInt();

        System.out.println("Меняем " + EnCurrency.index(currencyIn));

        System.out.println("Введите число: Какую валюту хотите получить");
        while (!scanner.hasNextInt()) {
            String str = scanner.next();
            System.out.println("вы ввели " + str + " введите число");
        }

        int currencyOut = scanner.nextInt();
        System.out.println("на " + EnCurrency.index(currencyOut));

        int valueCurrency;
        double result;

        Convertable usd = new UsdConversion();
        Convertable rub = new RubConversion();
        Convertable eur = new EuroConversion();
        Convertable jpy = new JpyConversion();

        switch (EnCurrency.index(currencyIn)) {
            case USD: {
                if (EnCurrency.index(currencyOut).equals(EnCurrency.RUB)) {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = usd.convertableToRub(valueCurrency);
                    System.out.println("результат Обмена " + EnCurrency.index(currencyIn) + " на "
                            + EnCurrency.index(currencyOut) + " = " + result);
                } else if (EnCurrency.index(currencyOut).equals(EnCurrency.EUR)) {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = usd.convertable(valueCurrency, usd.getRATEEURO());
                    System.out.println("результат Обмена " + EnCurrency.index(currencyIn) + " на "
                            + EnCurrency.index(currencyOut) + " = " + result);
                } else if (EnCurrency.index(currencyOut).equals(EnCurrency.JPY)) {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = usd.convertable(valueCurrency, usd.getRATEJPY());
                    System.out.println("результат Обмена " + EnCurrency.index(currencyIn) + " на "
                            + EnCurrency.index(currencyOut) + " = " + result);
                } else {
                    System.out.println("результат Обмена " + EnCurrency.index(currencyIn) + " на "
                            + EnCurrency.index(currencyOut) + " = " + EnCurrency.index(currencyIn));
                }
                break;
            }
            case RUB: {
                if (EnCurrency.index(currencyOut).equals(EnCurrency.USD)) {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = usd.convertableToRubToCurr(valueCurrency);
                    System.out.println("результат Обмена " + EnCurrency.index(currencyIn) + " на "
                            + EnCurrency.USD + " = " + result);
                } else if (EnCurrency.index(currencyOut).equals(EnCurrency.EUR)) {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = eur.convertableToRubToCurr(valueCurrency);
                    System.out.println("результат Обмена " + EnCurrency.index(currencyIn) + " на "
                            + EnCurrency.EUR + " = " + result);
                } else if (EnCurrency.index(currencyOut).equals(EnCurrency.JPY)) {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = jpy.convertableToRubToCurr(valueCurrency);
                    System.out.println("результат Обмена " + EnCurrency.index(currencyIn) + " на "
                            + EnCurrency.JPY + " = " + result);
                } else {
                    System.out.println("результат Обмена " + EnCurrency.index(currencyIn) + " на "
                            + EnCurrency.index(currencyOut) + " = " + EnCurrency.index(currencyIn));
                }
                break;
            }
            case EUR: {
                if (EnCurrency.index(currencyOut).equals(EnCurrency.USD)) {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = eur.convertable(valueCurrency, eur.getRATEUSD());
                    System.out.println("результат Обмена " + EnCurrency.index(currencyIn) + " на "
                            + EnCurrency.USD + " = " + result);
                } else if (EnCurrency.index(currencyOut).equals(EnCurrency.RUB)) {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = eur.convertableToRub(valueCurrency);
                    System.out.println("результат Обмена " + EnCurrency.index(currencyIn) + " на "
                            + EnCurrency.index(currencyOut) + " = " + result);
                } else if (EnCurrency.index(currencyOut).equals(EnCurrency.JPY)) {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = eur.convertable(valueCurrency, rub.getRATEJPY());
                    System.out.println("результат Обмена " + EnCurrency.index(currencyIn) + " на "
                            + EnCurrency.index(currencyOut) + " = " + result);
                } else {
                    System.out.println("результат Обмена " + EnCurrency.index(currencyIn) + " на "
                            + EnCurrency.index(currencyOut) + " = " + EnCurrency.index(currencyIn));
                }
                break;
            }
            case JPY: {
                if (EnCurrency.index(currencyOut).equals(EnCurrency.USD)) {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = jpy.convertable(valueCurrency, jpy.getRATEUSD());
                    System.out.println("результат Обмена " + EnCurrency.index(currencyIn) + " на "
                            + EnCurrency.index(currencyOut) + " = " + result);
                } else if (EnCurrency.index(currencyOut).equals(EnCurrency.RUB)) {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = jpy.convertableToRub(valueCurrency);
                    System.out.println("результат Обмена " + EnCurrency.index(currencyIn) + " на "
                            + EnCurrency.index(currencyOut) + " = " + result);
                } else if (EnCurrency.index(currencyOut).equals(EnCurrency.EUR)) {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = jpy.convertable(valueCurrency, jpy.getRATEEURO());
                    System.out.println("результат Обмена " + EnCurrency.index(currencyIn) + " на "
                            + EnCurrency.index(currencyOut) + " = " + result);
                } else {
                    System.out.println("результат Обмена " + EnCurrency.index(currencyIn) + " на "
                            + EnCurrency.index(currencyOut) + " = " + EnCurrency.index(currencyIn));
                }
                break;
            }

        }

    }
}

