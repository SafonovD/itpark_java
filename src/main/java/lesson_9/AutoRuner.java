package lesson_9;

import java.util.Arrays;
import java.util.Random;

/*
Необходимо организовать иерархию автомобилей, вводя  базовый абстрактный класс Automobile
с методом передвижения  move(distance).

Логика метода определяется непосредственно в  его наследниках классах Car (легковой автомобиль) и
Truck  (грузовик), которые следует сделать окончательными. Известно,  что для Car максимальная дистанция,
которую может проехать на  одном баке, составляет 500км, а Truck – 1200км.

В логике класса- запускателя следует сгенерировать 10 разнотипных автомобилей,
объединив их в рамках массива, и на каждом объекте вызвать  метод move со случайной дистанцией, ограниченной 1000км.
 */
public class AutoRuner {

    public static void main(String[] args) {
        Random random = new Random();

        int count=0;
        Automobile[] automobiles = new Automobile[10];

       while (count < automobiles.length){
           for (int i = 0; i < automobiles.length; i++) {
               if(i %2 != 0){
                   automobiles[i] = new Car(random.nextInt(1000));
               }else{
                   automobiles[i] = new Truck(random.nextInt(1000));
               }
           count++;
       }
           for (Automobile avto: automobiles) {
               avto.move();
           }

}





    }
}
