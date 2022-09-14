package Task3_7.Task3_7_2;

public class SumNumbers{

    public static <T extends Integer> void SumNumb(T[] array, SumNumbIF <T> ref) {
        T sum  = ref.sumNumb(array) ;
        System.out.println("Сума парних елементів становить: " + sum);
    }

    public static void main(String[] args) {
        SumNumbIF <Integer> refInt = (A) ->{
            Integer sum = 0;
            for ( int i : A){
                if (i % 2 != 0) {
                    sum +=i;
                }
            }
            return sum;
        };

        Integer[] arrInt = {5, 7, 4, 9, 15, 18, 6, 11, 9, 25, 27, 88};
        SumNumbers.SumNumb(arrInt, refInt);
    }
}

/*
        sum[0] = Arrays.stream(arrInt)
                .filter((a) -> (a%2)==0).sum();
        sum[1] = Arrays.stream(arrInt)
                .filter((a) -> (a%2)!=0).sum();
*/

//Завдання 2
//      • Реалізуй та продемонструй метод, що знаходить суму парних та непарних елементів цілочисельного масиву.
//      Метод повинен отримувати параметром лямбда-вираз, який визначає парність елементу та
//      використовувати його для обчислень. Продемонструй роботу методу для лямбда-виразів, які:

//        визначають, чи елемент масиву є парний;
//        визначають, чи елемент масиву є непарний.