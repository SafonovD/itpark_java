package lesson_7;
/*
Создать классы:
Собака, Домашний Кот, Тигр (можете добавить  два-три своих класса).
• Животные могут бежать и плыть. В качестве аргумента каждому  методу передается длина препятствия.
• У каждого животного есть ограничения на действия (бег: кот — 200 м, собака — 500 м; плавание:
кот — не умеет плавать, собака  — 10 м). Результатом выполнения действия будет печать в  консоль.
Например: dogBobik.run(150); -> 'Бобик пробежал 150  м'.
 */
public class AnimalRuner {
    public static void main(String[] args) {
        Cat cat = new Cat(200);
        Dog dog = new Dog(10,500);
        Cow cow = new Cow(20,150);
        Tiger tiger = new Tiger(50,800);


        cat.swim(15);
        cat.run(190);
        System.out.println("-------------");
        dog.swim(10);
        dog.run(190);
        System.out.println("-------------");
        cow.swim(15);
        cow.run(160);
        System.out.println("-------------");
        tiger.swim(15);
        tiger.run(290);
        System.out.println("-------------");
    }
}
