package lesson_9;

public final class Car extends Automobile {

    public Car() {
    }

    public Car(int distance) {
        super(distance);
    }

    @Override
    public void move() {
        if (getDistance() <= 500) {
            System.out.println("Автомобиль проехал " + getDistance());
        } else {
            System.out.println("Это расстояние " + getDistance() + " очень большое для Автомобиля");
        }
    }

    @Override
    public String toString() {
        return "Автомобиль {}";
    }
}
