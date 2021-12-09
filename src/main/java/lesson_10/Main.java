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
        int currency;
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
                if (EnCurrency.index(currencyOut).equals("RUB")) {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    usd.convertable(valueCurrency, usd.getRATERUB());
                    result = usd.convertable(valueCurrency, usd.getRATERUB());
                    System.out.println("результат Обмена "+ EnCurrency.index(currencyIn)+ " на "+ EnCurrency.RUB+ " = " + result );
                } else if (EnCurrency.index(currencyOut).equals("EUR")) {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = usd.convertable(valueCurrency, usd.getRATEEURO());
                    System.out.println("результат Обмена "+ EnCurrency.index(currencyIn)+ " на "+ EnCurrency.EUR+ " = " + result);
                } else {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    usd.convertable(valueCurrency, usd.getRATEJPY());
                    result = usd.convertable(valueCurrency, usd.getRATEJPY());
                    System.out.println("результат Обмена "+ EnCurrency.index(currencyIn)+ " на "+ EnCurrency.JPY+ " = " + result);
                }
            }
            case RUB: {
                if (currencyOut == 1) {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = rub.convertable(valueCurrency, rub.getRATEUSD());
                    System.out.println("результат Обмена "+ EnCurrency.index(currencyIn)+ " на "+ EnCurrency.USD+ " = " + result);
                } else if (currencyOut == 3) {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = rub.convertable(valueCurrency, rub.getRATEEURO());
                    System.out.println("результат Обмена "+ EnCurrency.index(currencyIn)+ " на "+ EnCurrency.EUR+ " = " + result);
                } else {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = rub.convertable(valueCurrency, rub.getRATEJPY());
                    System.out.println("результат Обмена "+ EnCurrency.index(currencyIn)+ " на "+ EnCurrency.JPY+ " = " + result);
                }
            }
            case EUR: {
                if (currencyOut == 1) {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = eur.convertable(valueCurrency, eur.getRATEUSD());
                    System.out.println("результат Обмена "+ EnCurrency.index(currencyIn) + " на "+ EnCurrency.USD+ " = " + result);
                } else if (currencyOut == 2) {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = eur.convertable(valueCurrency, eur.getRATERUB());
                    System.out.println("результат Обмена "+ EnCurrency.index(currencyIn) + " на "+ EnCurrency.RUB+ " = " + result);
                } else {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = rub.convertable(valueCurrency, rub.getRATEJPY());
                    System.out.println("результат Обмена "+ EnCurrency.index(currencyIn) + " на "+ EnCurrency.JPY+ " = " + result);
                }
            }
            case JPY: {
                if (currencyOut == 1) {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = jpy.convertable(valueCurrency, jpy.getRATEUSD());
                    System.out.println("результат Обмена "+ EnCurrency.index(currencyIn) + " на "+ EnCurrency.USD+ " = " + result);
                } else if (currencyOut == 2) {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = jpy.convertable(valueCurrency, jpy.getRATERUB());
                    System.out.println("результат Обмена "+ EnCurrency.index(currencyIn) + " на "+ EnCurrency.RUB+ " = " + result);
                } else {
                    System.out.println("Какое количество меняем");
                    valueCurrency = scanner.nextInt();
                    result = jpy.convertable(valueCurrency, jpy.getRATEEURO());
                    System.out.println("результат Обмена "+ EnCurrency.index(currencyIn) + " на "+ EnCurrency.EUR+ " = " + result);
                }
            }

        }

    }
}

