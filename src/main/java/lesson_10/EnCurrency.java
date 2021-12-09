package lesson_10;

public enum EnCurrency {

    USD(1),RUB(2),EUR(3),JPY(4);

    int index;

    EnCurrency(int index) {
        this.index = index;
    }

    public static EnCurrency index(int index){
        for (EnCurrency currency : values()) {
              if(currency.index == index){
                  return currency;
              }
        }
        return RUB;
    }



}
