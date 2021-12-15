package lesson_11;

public class Car extends Automobil{

    public Car() {
        super();
    }

    public Car(int speed, int carNumber, int weight, double height, double width, int length) {
        super(speed, carNumber, weight, height, width, length);
    }

    int carSpeed = getSpeed();
    @Override
    public void move() {
        if (getSpeed() > 80) {
            if(getSpeed()>=100){
                try {
                    System.out.println("Ваш автомобиль был остановлен за превышение 100км, ваша скорость" + getSpeed() +" номер машины "+ getCarNumber());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else{
                try {
                    System.out.println("Превышение скорости 80км, ваша скорость" + getSpeed());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        } else {

            System.out.println("Автомобиль едит со скоростью "+ getSpeed());
        }
    }

    @Override
    public void kpp() {
        if(getWeight() > 8){
            if(getHeight() >4 && getHeight()>2.5){

            }

        }

    }

    @Override
    public String toString() {
        return "Легковая{}";
    }
}
/*
1. Вес автомобиля не должен превышать 8 тон (в противном случае генерируется исключение о невозможности проезда и указании номера авто и его типа)

 2. Габариты авто не должны превышать 4 м высоты и 2.5 м ширины (иначе генерируется исключение, указанное в п.1)
 */