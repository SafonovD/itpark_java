package lesson_11;

public class Truck extends Automobiles {

    public Truck() {
        super();
    }

    public Truck(int speed, int carNumber, int weight, int height, double width, int length) {
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
        if(getWeight() > 8){
            if(getHeight() > 4 && getWidth() > 2.5){
                try{
                    System.out.println("Габариты не позволяют вам пройти КПП. Ваша высота "+ getHeight()+" и нирина "
                            + getWidth()+ " Номер Грузовика "+ getCarNumber());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else{
                try{
                    System.out.println("Вес Грузовика не позволяем вам пройти КПП. Ваш вес "+  getWeight()+" Номер Грузовика "+ getCarNumber());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }else{
            System.out.println("Грузовик КПП прошел успешно");
        }
    }

    @Override
    public String toString() {
        return "Грузовик {}";
    }
}
