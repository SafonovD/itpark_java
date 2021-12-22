package lesson_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeUtils {
    private static final List<String> NAMES = List.of("Вася", "Петя", "Надежда", "Константин", "Макс", "Сергей",
            "Любовь", "Махаил", "Евгений", "Татьяна", "Наталья", "Максим",
            "Людмила", "Юлия", "Снежана", "Николай", "Риналь", "Тимур");
    int count = 0;

    private List<Employee> employees = new ArrayList<>();

    public void fillUpEmploees(int n) {

        while(count < n) {
            int randomIndex = new Random().nextInt(NAMES.size());
            employees.add(new Employee(NAMES.get(randomIndex), new Random().nextInt(80), new Random().nextInt(50)));
            count++;
        }
    }

    public void print(int WorkAge){
        for (Employee list : this.employees) {
            if(list.getWorkAge() == WorkAge) {
                System.out.println(list);
            }
        }

    }
}
