package lesson_21;


import org.junit.Assert;
import org.junit.Test;

public class CalcTest {

    @Test
    public void shouldCalculatorCanCalculateSummа(){
        Calc calc = new Calc(10,20);
        Assert.assertEquals(30,calc.summa());

        Calc calc2 = new Calc(-10,20);
        Assert.assertEquals(10,calc2.summa());

        Calc calc3 = new Calc(50,20);
        Assert.assertEquals(70,calc3.summa());
    }
}
