package lesson_10.convert;

import lesson_10.Convertable;

public class JpyConversion implements Convertable {


    @Override
    public double convertable(double value1, double rate){
        return (value1*RATEJPY)/rate;
    }
    @Override
    public double convertableToRub(double valueCurrency) {
        return valueCurrency * RATEJPY;
    }
    public double convertableToRubToCurr(double valueCurrency) {
        return valueCurrency / RATEJPY;
    }
}
