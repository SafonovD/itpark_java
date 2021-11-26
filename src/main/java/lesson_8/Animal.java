package lesson_8;

import java.util.Objects;

public class Animal  {
    String name;
    int age;
    int weight;

    public Animal(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public void voice(){
        System.out.println("У животных есть голос");
    }

    @Override
    public String toString() {
        return " Животное {"
                +"Имя = '" + name + '\''
                +", Возраст = " + age
                +", Вес = " + weight
                +'}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (age != animal.age) return false;
        if (weight != animal.weight) return false;
        return Objects.equals(name, animal.name);
    }

}
