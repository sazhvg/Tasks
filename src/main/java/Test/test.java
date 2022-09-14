package Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;

public class test {
    public static void main(String[] args) {

        String [] students= {"Антонов", "Шевченко", "Бойко", "Шевченко", "Кравченко", "Савицький", "Антонов", "Шевченко", "Тетерів"};
        List<String> list = new ArrayList<>();
        Set<String> studentslist = new TreeSet<>();
        Map<String, Integer> map = new HashMap<>();

        //        list.add(stud[0]);
//        list.add(stud[1]);
//        list.add(stud[2]);

        for (String student: students){
            list.add(student);
            studentslist.add(student);
        }
        System.out.println("Кількість єлементів у списку" + (list.size()));
        System.out.println("Кількість єлементів у колекції" + (studentslist.size()));

        for (String student: studentslist){
            map.put(student, student.length());
        }


/*        Set<Integer> cas = new HashSet<>();
        cas.add(1);
        cas.add(2);
        cas.add(5);
        cas.add(20);
        cas.add(5);
        cas.add(100);
        cas.add(5);

        Map<String, Float> pr = new HashMap<>();
        pr.put("Картопля", 9.89F);
        pr.put("Молоко", 10.15F);
        pr.put("Хліб", 5.55F);
        System.out.println(pr.get("Хліб"));*/
    }
}
