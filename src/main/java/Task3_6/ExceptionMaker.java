package Task3_6;

public class ExceptionMaker {

    public static void main(String[] args) throws SaferException {
        new ExceptionMaker().isThereTwo(getData());
    }
    public boolean isThereTwo(Object[] objectsArray) throws SaferException {
        for (Object someObject : objectsArray) {
            // Додати код, що перехоплює вийняток NullPointerException та повертає SaferException
            try {
                if (someObject.equals(2)) {
                    return true;
                }
            } catch (NullPointerException e) {
                new SaferException(e);
            }
        }
        return false;
    }
    public static Object[] getData() {
        return new Object[] { new Object(), null, "test data", 2 };
    }
}

//Крок 2. Оновить метод isThereTwo класу ExceptionMaker так,
// щоб він був захищений від виникнення помилки NullPointerException,
// та замість неї повертав власну реалізацію помилки - SaferException.
// Для того, щоб використовувати SaferException, змініть клас таким чином,
// щоб його можна було використовувати разом із конструкцією throw new SaferException()


//        використайте конструкцію try-catch для перехоплення помилки NullPointerException
//        додайте до сигнатур методів isThereTwo та main конкструкцію throws SaferException за потреби