package lesson_13;
/*
Необходимо создать класс, описывающую сущность работника (Employee), важными характеристиками которого являются ФИО,
табельный номер и общий стаж работы в организации. Необходимо реализовать метод печати в консоль имена тех рабочих,
которые имеют указанный стажтработы EmployeeUtils#printEmployee(Collection<Employee> employees, int workAge),

где employees - коллекция сотрудников, а workAge - стаж работы в организации

• Для обхода коллекции используйте итератор.

• Естественным является заполнение коллекции десятком/сотней объектов класса Employee, которые создаются удобным для
Вас способом, запрашивая из консоли или инициализирую в логике программы. В качестве передаваемой на вход коллекции
предполагается передача списка, множества или очереди.

• Дополнительно необходимо реализовать метод удаления элементов коллекции, стоящих на нечетных позициях, обходя список
с конца
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeUtils employeeUtils = new EmployeeUtils();
        System.out.println("Введите число работников");
        int value = scanner.nextInt();
        employeeUtils.fillUpEmploees(value);

       System.out.println("Введите стаж работы ");
       value = scanner.nextInt();
        employeeUtils.printWorkAge(value);
        System.out.println();
        System.out.println(" ----- Удаление элементов коллекции ----- ");

         employeeUtils.remove();
    }
}
