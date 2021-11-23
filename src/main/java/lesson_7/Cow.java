package lesson_7;

public class Cow {
    private int maxDistanceSwim;
    private int maxDistanceRun;

    public Cow() {
    }

    public Cow(int maxDistanceSwim, int maxDistanceRun) {
        this.maxDistanceSwim = maxDistanceSwim;
        this.maxDistanceRun = maxDistanceRun;
    }

    public void swim(int value) {
        if (value > maxDistanceSwim) {
            System.out.println("Корова столько не плывет");
        } else {
            System.out.println("Корова проплыла " + value + "м");
        }
    }
    public void run(int value) {
        if (value <= maxDistanceRun) {
            System.out.println("Корова корова класно бегает " + value +"м");
        } else {
            System.out.println("Корова устала " + value +"м это слишком много");
        }
    }
}
