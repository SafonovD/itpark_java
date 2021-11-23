package lesson_7;

public class Tiger {
    private int maxDistanceSwim;
    private int maxDistanceRun;

    public Tiger() {
    }

    public Tiger(int maxDistanceSwim, int maxDistanceRun) {
        this.maxDistanceSwim = maxDistanceSwim;
        this.maxDistanceRun = maxDistanceRun;
    }

    public void swim(int value) {
        if (value < maxDistanceSwim & value > 1 ) {
            System.out.println("Тигр хорошо плавает, "+value+"м для него простая задача");
        } else {
            System.out.println("Тигр проплыл " + value + " м");
        }
    }
    public void run(int value) {
        if (value < maxDistanceRun & value > 1) {
            System.out.println("Тигр класно бежит, " + value +"м для него простая задача");
        } else {
            System.out.println("Тигр устал, " + value +" м это слишком много");
        }
    }
}
