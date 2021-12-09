package lesson_9;

public final class Truck extends Automobile {

    public Truck() {
    }

    public Truck(int distance) {
        super(distance);
    }

    @Override
    public void move() {
        if (getDistance() <= 500) {
            System.out.println("Грузовик проехал " + getDistance());
        } else {
            System.out.println("Это расстояние " + getDistance() + " очень большое для Грузовика");
        }
    }

    @Override
    public String toString() {
        return "Грузовик {}";
    }
}
