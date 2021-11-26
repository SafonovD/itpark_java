package lesson_8;

public class Cow extends Animal{
    public Cow(String name, int age, int weight) {
        super(name, age, weight);
    }

    public void voice(){
        System.out.println("Корова Мычит МУУУУ--ууу");
    }
    @Override
    public String toString() {
        return "\nКорова {"
                +"Имя = '" + name + '\''
                +", Возраст = " + age
                +", Вес = " + weight
                +'}';
    }
}
