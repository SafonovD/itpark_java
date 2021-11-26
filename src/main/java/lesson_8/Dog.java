package lesson_8;

public class Dog extends Animal{
    public Dog(String name, int age, int weight) {
        super(name, age, weight);
    }

    public void voice(){
        System.out.println("Собака гавкает Гав-Гав");
    }
    @Override
    public String toString() {
        return "\nСобака {"
                +"Имя = '" + name + '\''
                +", Возраст = " + age
                +", Вес = " + weight
                +'}';
    }
}

