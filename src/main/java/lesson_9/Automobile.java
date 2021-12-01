package lesson_9;

public abstract class Automobile {
    private int distance;

    public Automobile(){}
    public Automobile(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public abstract void move();

}
