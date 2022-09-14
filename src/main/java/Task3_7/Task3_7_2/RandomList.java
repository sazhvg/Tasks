package Task3_7.Task3_7_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class RandomList {
    public static void main(String[] args) {

        List <Double> arrayList = craeteList(10);

// Питання до куратора: довго не мог вирішити завдання із-за типів <Double> в List.
// Як щоб Idea не підставила Optional<Double>, то мабуть би ще довбався.
// Вважаю, що Optional<Double> - не самий вірний варіант. Прошу надати консультацію з цього приводу.

        Optional<Double> sum = arrayList
                .stream()
                .map(a -> a * a)
                .reduce((total, a) -> (total+ a));

        System.out.println(sum);
    }
    public static List <Double> craeteList(int length){

        List <Double> list = new ArrayList(length);
        for(int i = 0; i < length; i++) {
            list.add(Math.random());
        }
        return list;
    }

}

//Завдання 2
//        • Створи список з 10 елементів і заповни його рандомними числами,
//        потрібно вивести суму квадратів всіх елементів списку.
//        Використай метод map () для зведення в квадрат кожного елемента,
//        а потім застосуй метод reduce () для згортки всіх елементів в одне число.
