package lesson_10;

public interface Convertable {

     double RATERUB = 1;
     double RATEEURO = 83.36;
     double RATEUSD = 73.84;
     double RATEJPY = 65.03;


     double convertable(double valueCurrency, double rate);

     double convertableToRub(double valueCurrency);

     double convertableToRubToCurr(double valueCurrency);


    default double getRATEUSD() {
          return RATEUSD;
     }
    default double getRATEEURO() {
        return RATEEURO;
    }
    default double getRATERUB() {
        return RATERUB;
    }
    default double getRATEJPY() {
        return RATEJPY;
    }



}
