package lesson_11;

public class Car extends Automobil{

    public Car() {
        super();
    }

    public Car(int speed, int carNumber, int weight, int height, double width, int length) {
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
            if(getHeight() >= 4 & getWidth() >= 2.5){
                try{
                    System.out.println("Габариты не позволяют вам пройти КПП. Ваша высота "+ getHeight()+" и нирина "
                    + getWidth()+ " Номер Автомобилья "+ getCarNumber());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else{
                try{
                    System.out.println("Вес Автомобиль не позволяем вам пройти КПП. Ваш вес "+  getWeight()+" Номер Автомобилья "+ getCarNumber());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }else{
            System.out.println("Автомобиль КПП прошел успешно");
        }
    }

    @Override
    public String toString() {
        return "Легковая{}";
    }
}