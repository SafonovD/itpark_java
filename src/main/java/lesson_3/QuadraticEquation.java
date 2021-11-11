package lesson_3;

import java.util.Scanner;

/*
Метод принимает в качестве аргументов коэффициенты a, b, c квадратного уравнения ().

В теле метода требуется вывести на экран значения корней этого уравнения согласно следующим правилам:

если первый коэффициент a равен нулю, то вывести "Первый коэффициент не может быть 0";
если уравнение не имеет корней, то вывести "Нет действительных решений уравнения";
если уравнение имеет два корня, то вывести их в строку через пробел (для одного корня, достаточно одного значения).
 */
public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a, b, c;
        double diskriminant;
        System.out.println("Введите числа a, b, c ");
        System.out.println("Для решения уравнения : a*x^+b*x+c=0");
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();

        diskriminant = b * b - 4 * a * c;

        if (diskriminant > 0) {
            if (a == 0) {
                System.out.println("Первый коэффициент не может быть 0");
            } else {
                double x1, x2;
                x1 = (-b - Math.sqrt(diskriminant)) / (2 * a);
                x2 = (-b + Math.sqrt(diskriminant)) / (2 * a);
                System.out.println("Корни уравнения: x1 = " + x1 + ", x2 = " + x2);
            }
        } else if (diskriminant == 0) {
            double x;
            x = -b / (2 * a);
            System.out.println("Уравнение имеет единственный корень: x = " + x);
        } else {
            System.out.println("Нет действительных решений уравнения");
        }
    }
}
