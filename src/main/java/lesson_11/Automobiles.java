package lesson_11;

public abstract class Automobiles {

    private int speed;
    private int carNumber;
    private int weight;
    private int height ;
    private double width;
    private int length;

    public Automobiles(){}

    public Automobiles(int speed, int carNumber, int weight, int height, double width, int length) {
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
