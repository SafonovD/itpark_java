package lesson_21;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calc {

    private int arg1;
    private int arg2;

    public int summa() {
        return arg1 + arg2;
    }
}
