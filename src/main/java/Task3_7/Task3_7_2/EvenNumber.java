package Task3_7.Task3_7_2;

import java.util.ArrayList;
import java.util.List;

public class EvenNumber {
    public static void main(String[] args) {

        List<Integer> arrayList = craeteList(1000);
        long count =  arrayList
                .stream()
                .filter(a -> a%2==0)
                .count();

            System.out.println(count);
        }
        public static List <Integer> craeteList(int length){

            List <Integer> list = new ArrayList(length);
            for(int i = 0; i < length; i++) {
                list.add((int)Math.round(Math.random()*2147483647));
            }
            return list;
        }

    }

//Завдання 2
//        • Для будь-якого набору випадково-згенерованих цілих чисел потрібно визначити кількість парних.
//        Для розв’язку задачі використай засоби програмного інтерфейсу Stream API.
