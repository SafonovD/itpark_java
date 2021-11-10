package lesson_2.Converter;

public class Distance {

    public static double distance;

    public void print() {
        System.out.println("Длина  = " + distance);
    }

    public static class Converter {

        public double convertMToKm(double value) {
            distance = value / 1000;
            return distance;
        }
        public double convertSmToDm(double value) {
            distance = value * 10;
            return distance;
        }
        public double convertMmToSm(double value) {
            distance = value * 10;
            return distance;
        }
    }
}
