package lesson_11;

public abstract class Automobil {

    private int speed;
    private int carNumber;
    private int weight;
    private double height ;
    private double width;
    private int length;

    public Automobil(){}

    public Automobil(int speed, int carNumber, int weight, double height, double width, int length) {
        this.speed = speed;
        this.carNumber = carNumber;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public abstract void move();
    public  abstract void kpp();

    public int getSpeed() {
        return speed;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }
}
