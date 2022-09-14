package Task3_7.Task3_7_2;

public class StreamNumber {

    public static int flagNumber  (int item, FilterNumber ref) {
        return ref.flagNumber(item);
    }

    public static void main(String[] args) {
        FilterNumber refIntEven = (a) ->{return a % 2 == 0 ? a:0;};
        FilterNumber refIntOdd = (a) ->{return a % 2 != 0 ? a:0;};

        int [] arrInt = {5, 7, 4, 10, 15, 18, 6, 11, 9, 25, 27, 88};
        int [] sum = {0,0};

        for ( int i : arrInt){
            sum[0] += StreamNumber.flagNumber(i, refIntEven);
            sum[1] += StreamNumber.flagNumber(i, refIntOdd);
        }

        System.out.println("Сума парних елементів становить: " + sum[0] +
                "\nСума непарних елементів становить: " + sum[1]);
    }
}

//Завдання 2
//      • Реалізуй та продемонструй метод, що знаходить суму парних та непарних елементів цілочисельного масиву.
//      Метод повинен отримувати параметром лямбда-вираз, який визначає парність елементу та
//      використовувати його для обчислень. Продемонструй роботу методу для лямбда-виразів, які:

//        визначають, чи елемент масиву є парний;
//        визначають, чи елемент масиву є непарний.
