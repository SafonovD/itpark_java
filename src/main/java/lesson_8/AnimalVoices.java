package lesson_8;

import java.util.Arrays;

public class AnimalVoices {
    public static void main(String[] args) {

        Animal cat = new Cat("Мурзик", 2, 5);
        Animal dog = new Dog("Бобик", 5, 15);
        Animal frog = new Frog("Квакша", 1, 1);
        Animal cow = new Cow("Буренка", 3, 60);

        cat.voice();
        System.out.println(cat);
        System.out.println("______________");
        dog.voice();
        System.out.println(dog);
        System.out.println("______________");
        frog.voice();
        System.out.println(frog);
        System.out.println("______________");
        cow.voice();
        System.out.println(cow);
        System.out.println("______________");


        Animal[] animals = {cat, dog, frog, cow};
        for (Animal animal : animals) {
            animal.voice();
        }
    }
}

