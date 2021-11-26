package lesson_7;

public class Cat {
    private int maxDistanceSwim = 1;
    private int maxDistanceRun;

    public Cat() {
    }

    public Cat(int maxDistanceRun) {
        this.maxDistanceRun = maxDistanceRun;
    }

    public Cat(int maxDistanceSwim, int maxDistanceRun) {
        this(maxDistanceSwim);
        this.maxDistanceRun = maxDistanceRun;
    }

    public void swim(int value) {
        if (value > maxDistanceSwim || value <= 0) {
            System.out.println("Кот не умеет плавать");
        }
    }
    public void run(int value) {
        if (value < maxDistanceRun ) {
            System.out.println("Кот класно бежит " + value +"м");
        } else {
            System.out.println("Кот устал, " + value +" м это слишком много");
        }
    }

}
