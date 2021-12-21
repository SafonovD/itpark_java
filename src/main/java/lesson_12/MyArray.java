package lesson_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyArray {
    public static final int ROWS = 4;
    public static final int COLUMNS = 4;

    private static final List<String> SYMBOL = List.of("25", "5", "58", "78",
                                                        "3", "-7", "28", "0",
                                                        "8", "12", "54", "5",
                                                       "13", "57", "32", "-69");

    private List<List<String>> num;

    public MyArray(int m, int n) {
        if (m != ROWS || m != COLUMNS) {
            throw new MyArraySizeException("Неправильный размер массива");
        }
        this.num = new ArrayList<>(n);
        fillupMatrix(m, n);
    }

    public void fillupMatrix(int m, int n) {
        for (int i = 0; i < m; i++) {
            List<String> lin = new ArrayList<>(n);
            this.num.add(lin);
            for (int j = 0; j < n; j++) {
                int randomIndex = new Random().nextInt(SYMBOL.size());
                lin.add(SYMBOL.get(randomIndex));
            }
        }
    }

    public int SummElement(){
        int result = 0;
        for (int i = 0; i < this.num.size(); i++) {
             List<String> rw = this.num.get(i);
            for (int j = 0; j < rw.size(); j++) {
                String value = rw.get(j);
                try {

                    result += Integer.parseInt(value);
                    } catch (Exception e) {
                       throw new MyArrayDataException("в ячейке массива лежит что-то не то", i+1, j+1);
                }
            }
        }
        return result;
      }

      public void print(){
          for (List<String> list: this.num) {
              System.out.println(list);
          }
      }
 }

