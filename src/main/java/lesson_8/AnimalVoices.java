package lesson_8;


public class AnimalVoices {
    public static void main(String[] args) {

        Animal cat = new Cat("Мурзик", 2, 5);
        Animal dog = new Dog("Бобик", 5, 15);
        Animal frog = new Frog("Квакша", 1, 1);
        Animal cow = new Cow("Буренка", 3, 60);


        Animal[] animals = {cat, dog, frog, cow};
        for (Animal animal : animals) {
            animal.voice();
        }
    }
}

