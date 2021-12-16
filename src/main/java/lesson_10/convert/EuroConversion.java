package lesson_10.convert;
import lesson_10.Convertable;

public class EuroConversion implements Convertable {

    @Override
    public double convertable(double valueCurrency, double rate) {
        return (valueCurrency*RATEEURO)/rate;
    }
    @Override
    public double convertableToRub(double valueCurrency) {
        return valueCurrency * RATEEURO;
    }

    @Override
    public double convertableToRubToCurr(double valueCurrency) {
        return valueCurrency / RATEEURO;
    }
}
