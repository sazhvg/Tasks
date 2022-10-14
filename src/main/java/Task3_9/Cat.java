package Task3_9;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Cat {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Animal animal = new Animal(20);

        Class<?> animalClass = null;
        try {
            animalClass = Class.forName("Task3_9.Animal");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Field[] Fields = animalClass.getDeclaredFields();// отримати змінні класу
        System.out.println(msgFields(animal, Fields) + msgMethods(animal)); // отримати змінні класу

        Field field1 = animalClass.getDeclaredField("nameGroup");
        field1.setAccessible(true);
        field1.set(animal, "ANIMAL");

        Field field2 = animalClass.getDeclaredField("numberGroup");
        field2.setAccessible(true); // для примусової зміни
        field2.set(animal, 111);

        Field field3 = animalClass.getDeclaredField("age");
        field3.setAccessible(true);
        field3.set(animal, 50);
        System.out.println("Значення полей змінено:"); // отримати змінні класу
        System.out.println(msgFields(animal, Fields)); // отримати змінні класу
    }

    public static String msgFields(Animal item, Field[] fields) throws IllegalAccessException {
        String msg, i;
        msg = String.format("Клас %s має наступні поля: %n", item.getClass());
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            String mod;
            if (Modifier.isPrivate(modifiers)){
                mod = "private";
            }else if (Modifier.isProtected(modifiers)){
                mod = "protected";
            }else if (Modifier.isPublic(modifiers)){
                mod = "public";
            }else{
                mod = "default";
            }
            if (Modifier.isStatic(modifiers)){
                mod = mod + " static";
            }
            if (Modifier.isFinal(modifiers)){
                mod = mod + " final";
            }
            field.setAccessible(true);
            Class<?> type = field.getType();
            i="";
            i = i + field.get(item);  // Якось так
            msg = msg + String.format("поле: %s %s %s, значення: %s  %n", mod, type, field.getName(), i);
        }
        return msg;
    }
    public static String msgMethods(Animal item) {
        String method;

        method = "Клас має наступні методи: ";
        Method[] methods = item.getClass().getDeclaredMethods();
        for (Method m : methods){
            method = method + "\n" + m;
        }
        return method;
    }
}
/*
• Створи два класи: Animal і Cat.

        У класі Animal ініціалізуй 3 поля різних модифікаторів
        У класі Cat використовуючи рефлексію отримай доступ до полів класу Animal і змініть вміст кожного з полів.

• Напиши програму, яка буде виводити всю інформацію про клас: користувач сам вибирає, який саме клас цікавить.*/
