package lesson_11;

public class Truck extends Automobil{

    public Truck() {
        super();
    }

    public Truck(int speed, int carNumber, int weight, double height, double width, int length) {
        super(speed, carNumber, weight, height, width, length);
    }

    @Override
    public void move() {
        if (getSpeed() > 80) {
            if(getSpeed()>=100){
                try {
                    System.out.println("Ваш Грузовик был остановлен за превышение 100км, ваша скорость " + getSpeed() +" номер машины "+ getCarNumber());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else{
                try {
                    System.out.println("Превышение скорости 80км, ваша скорость " + getSpeed());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Грузовик едит со скоростью "+ getSpeed());
        }
    }

    @Override
    public void kpp() {

    }

    @Override
    public String toString() {
        return "Грузовик {}";
    }
}
