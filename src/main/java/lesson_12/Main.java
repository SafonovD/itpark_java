package lesson_12;

/*
Создайте исключения: MyArraySizeException (неправильный размер массива), и  MyArrayDataException (в ячейке массива лежит что-то не то);

• Напишите метод, на вход которого подаётся двумерный строковый массив (String[][]) размером 4×4. При подаче массива другого размера
необходимо бросить исключение  MyArraySizeException.

• Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе массива преобразование
не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией,
 в какой именно ячейке лежат неверные данные. Расчет данных для этой матрицы прекращается.

• В методе main() нужно вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException и вывести результат расчёта
 */
public class Main {
    public static void main(String[] args) {
        MyArray myArray = new MyArray(4,4);

        System.out.println(myArray.SummElement());
        System.out.println();

        myArray.print();


    }
}
