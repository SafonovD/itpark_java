package lesson_7;

public class Dog {
    private int maxDistanceSwim;
    private int maxDistanceRun;

    public Dog() {
    }

    public Dog(int maxDistanceSwim, int maxDistanceRun) {
        this.maxDistanceSwim = maxDistanceSwim;
        this.maxDistanceRun = maxDistanceRun;
    }

    public void swim(int value) {
        if (value > maxDistanceSwim) {
            System.out.println("Собака столько не плывет");
        } else {
            System.out.println("Собака проплыла " + value + " м");
        }
    }
    public void run(int value) {
        if (value < maxDistanceRun) {
            System.out.println("Собака класно бежит " + value +"м");
        } else {
            System.out.println("Собака устала " + value +" м это слишком много");
        }
    }
}
