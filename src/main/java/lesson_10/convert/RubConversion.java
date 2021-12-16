package lesson_10.convert;

import lesson_10.Convertable;


public class RubConversion implements Convertable {


    @Override
    public double convertable(double valueCurrency, double rate) {
        return (valueCurrency*RATERUB)/rate;
    }
    @Override
    public double convertableToRub(double valueCurrency) {
        return valueCurrency * RATERUB;
    }
    public double convertableToRubToCurr(double valueCurrency) {
        return valueCurrency / RATERUB;
    }
}
