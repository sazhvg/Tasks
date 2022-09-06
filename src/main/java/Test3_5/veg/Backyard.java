package Test3_5.veg;

import Test3_5.veg.storage.Box;
import Test3_5.veg.vegetables.Cucumber;
import Test3_5.veg.vegetables.Tomato;
import Test3_5.veg.vegetables.Vegetable;

import java.util.List;


public class Backyard {
    public static void main(String[] args) {

        Box<Vegetable> box1 = new Box<>();
        box1.put(new Tomato(100));
        box1.put(new Cucumber(80));
        box1.put(new Tomato(70));
        box1.put(new Tomato(40));

        List<Vegetable> vegetables = box1.getThing();

        Vegetable v = vegetables.get(2);

        Box<Tomato> box2 = new Box<>();
        box2.put(new Tomato(100));
//        box2.put(new Cucumber(80));
        box2.put(new Tomato(70));
        box2.put(new Tomato(40));

    }
}
