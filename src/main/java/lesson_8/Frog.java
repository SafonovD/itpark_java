package lesson_8;

public class Frog extends Animal{
    public Frog(String name, int age, int weight) {
        super(name, age, weight);

    }
    public void voice(){
        System.out.println("Лягушка квакает Ква - Ква");
    }
    @Override
    public String toString() {
        return "\nЛягушка {"
                +"Имя = '" + name + '\''
                +", Возраст = " + age
                +", Вес = " + weight
                +'}';
    }
}
