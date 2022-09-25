package Task3_9;


public class Animal {

    private static String nameGroup = "Animal";

    public final int numberGroup = 555;

    private int age;

    public Animal(int age) {
        this.age = age;
    }

    public static String getNameGroup() {
        return nameGroup;
    }

    public int getAge() {
        return age;
    }
}
