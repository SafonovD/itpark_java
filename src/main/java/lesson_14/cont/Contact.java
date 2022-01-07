package lesson_14.cont;

import lesson_14.utill.FullNameUtill;
import lesson_14.utill.PhoneUtill;
import lombok.Getter;
import lombok.ToString;

import java.util.Collection;
import java.util.HashSet;

@Getter


public class Contact {
    private final String name;
    private final String surname;
    private  final String patronymic;
    private final String phone;


    public Contact(){
        this(FullNameUtill.randomName(),FullNameUtill.randomSurname(),FullNameUtill.randomPatronymic(), PhoneUtill.generatePhone());
    }

    public Contact(String name, String surname, String patronymic, String phone) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phone = phone;

    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
