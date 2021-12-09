package lesson_10.convert;

import lesson_10.Convertable;

public class UsdConversion implements Convertable {

    @Override
    public double convertable(double valueCurrency, double rate) {
       return (valueCurrency*RATEUSD)/rate;
    }

}
