package Task3_6;

// Змінити клас так, щоб його можна було використовувати у якості винятка
public class SaferException extends Throwable {

    public SaferException(NullPointerException e ) {
        super();
        e.printStackTrace();// Як варіант, сюди можлово записати необхідний метод
        System.out.println(1);

    }
}
