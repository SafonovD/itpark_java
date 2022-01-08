package lesson_14;

import lesson_14.cont.Contact;
import lesson_14.cont.ContactWithOther;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Реализовать сущность «Телефонный справочник», в котором разместить такие важные атрибуты как информацию об абоненте -
ФИО, номере телефона, списке связанных контактов. По желанию, можно разместить принадлежность к оператору сотовой связи
(в виде перечисления – Мегафон, Билайн, МТС, Теле2, с хранением пула кодов оператора), признак городской/сотовый.

• После этого заполнить 10000 (в зависимости от размера установленной на ПК памяти, можно и больше) данных сущностей
произвольными значениями, а для их хранения следует воспользоваться такими коллекциями, как список, множество и карта
записей (очередь опционально использовать).

• Попытаться «оббежать» данные (можно в обратном порядке) и найти телефонные номера, которые наиболее популярны у
других абонентов (т.е. найти часто встречающиеся номера в списке связанных контактов). Для тех же самых целей
воспользоваться обычными массивами данных, сравнив их производительность, замерив время работы программы в каждом отдельном случае.

• В итоге, определить насколько целесообразно хранить такие объемы данных в коллекциях или лучше воспользоваться привычными массивами
 */
public class Main {
    private static final Integer LIMIT = 1000;
    private static final Integer LIMIT_OF_LINKED_KONT = 100;

    public static void main(String[] args) {

        //     System.out.println(Arrays.toString(contact));

      ContactWithOther[] contactsArray = genrateElementArrayAdnMeasureTame(Main::fillContactArrays);
      Collection<ContactWithOther> contactList = genrateElementAndsMeasureTame(Main::fillContactList);
      Collection<ContactWithOther> contactSet = genrateElementAndsMeasureTame(Main::fillContactSet);

        System.out.println("--------------");
        fillLinketContacts(contactList);
        System.out.println("--------------");
        fillLinketContacts(contactSet);

        System.out.println("--------------");
        Map<Contact, Collection<Contact>> mapOfContactLinkedContact = contactList.stream()
                .collect(Collectors.toMap(Contact::new, ContactWithOther::getLinkedContact));

        System.out.println(mapOfContactLinkedContact);

        Map<Contact, Integer> mapOfContact = contactList.stream().map(ContactWithOther::getLinkedContact)
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(Function.identity(), contact -> 1, Integer::sum));

        System.out.println("--------------");
        System.out.println(contactList);
        System.out.println("--------------");

        Optional<Map.Entry<Contact, Integer>> maxPopularContact = mapOfContact.entrySet().
                stream().max(Map.Entry.comparingByValue());

        maxPopularContact.ifPresent(System.out::println);
    }

    private static void fillLinketContacts(Collection<ContactWithOther> contactList) {
        long now = System.currentTimeMillis();
        for (ContactWithOther contact: contactList){
            IntStream.range(0,LIMIT_OF_LINKED_KONT).boxed().map(i -> randomElement(contactList)).
                    forEach(contact.getLinkedContact()::add);
        }
        long spentTime = System.currentTimeMillis() - now;
        System.out.printf("Мы заполнили связанные контакты %s размером %d элементов за %.2f секунд\n",
                contactList instanceof List ? "Cписка" : "Множества",
                LIMIT_OF_LINKED_KONT, spentTime / 1000d);
    }

    public static ContactWithOther[] genrateElementArrayAdnMeasureTame(Supplier<ContactWithOther[]> supplier) {
        long now = System.currentTimeMillis();
        ContactWithOther[] collection = supplier.get();
        long spentTime = System.currentTimeMillis() - now;
        System.out.printf("Мы заполнили Массив размером %d элементов за %.2f секунд\n", collection.length, spentTime / 1000d);
        return collection;
    }

    public static Collection<ContactWithOther> genrateElementAndsMeasureTame(Supplier<Collection<ContactWithOther>> supplier) {
        long now = System.currentTimeMillis();
        Collection<ContactWithOther> collection = supplier.get();
        long spentTime = System.currentTimeMillis() - now;
        System.out.printf("Мы заполнили %s размером %d элементов за %.2f секунд\n",
                collection instanceof List ? "Cписк" : "Множество",
                collection.size(), spentTime / 1000d);
        return collection;
    }

    private static ContactWithOther[] fillContactArrays() {
        ContactWithOther[] contact = new ContactWithOther[LIMIT];
        for (int i = 0; i < contact.length; i++) {
            contact[i] = new ContactWithOther();
        }
        return contact;
    }

    private static List<ContactWithOther> fillContactList() {
        List<ContactWithOther> contact = new ArrayList<>(LIMIT);
        IntStream.range(0, LIMIT).forEach(value -> {
            contact.add(new ContactWithOther());
        });
        return contact;
    }

    private static Set<ContactWithOther> fillContactSet() {
        Set<ContactWithOther> contact = new HashSet<>(LIMIT);
        IntStream.range(0, LIMIT).forEach(value -> {
            contact.add(new ContactWithOther());
        });
        return contact;
    }

    public static ContactWithOther randomElement(Collection<ContactWithOther> collection){
       int counter = 0;
       int randomCounter = new Random().nextInt(collection.size());
       for (ContactWithOther contact : collection){
           if(counter++ == randomCounter){
               return contact;
           }
       }
       throw new IllegalArgumentException("Тут ошибка");
    }
}
