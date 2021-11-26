package lesson_8;

public class Cat extends Animal{

    public Cat(String name, int age, int weight) {
        super(name, age, weight);

    }
    public void voice(){
        System.out.println("Кошка мяучит МЯУуу");
    }
    @Override
    public String toString() {
        return "Кошка {"
                +"Имя = '" + name + '\''
                +", Возраст = " + age
                +", Вес = " + weight
                +'}';
    }

}
