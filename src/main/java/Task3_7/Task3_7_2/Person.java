package Task3_7.Task3_7_2;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public static void main(String[] args) {

        List<String> List = new ArrayList<>();
        List.add("Bob");
        List.add("Jon");
        List.add("Jemmy");
        List.add("Jilia");
        List.add("Semona");
        List
                .stream()
                .filter(name -> name.startsWith("J"))
                .forEach(System.out::println);
    }
}
//Завдання 2
//        • Задано набір прізвищ співробітників. Розроби програму, що показує всі прізвища,
//        які починаються на букву ‘J’. Задачу розв’язати з використанням програмного інтерфейсу Stream API.
