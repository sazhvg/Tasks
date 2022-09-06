package Test3_5.veg;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompleteMethods {

    public static void main(String[] args) {
        getUniqueMeasurableItems(List.of(new Apple(), new WaterMelon(), new Tomato())); // 1
        getUniqueMeasurableItems(List.of(new Coin(), new Toy(), new Chair())); // 2
        getUniqueMeasurableItems(List.of(new Water(), new Juice(), new Oil())); // 3
        var packedBeverages = getUniqueMeasurableItems(List.of(new CanOfCoke(), new BottleOfJuice())); // 4
    }

//    public static <T /* тут вписати визначення типу T */> Set<T> getUniqueMeasurableItems(List<T> list) {
//        // some specific processing to happen here
 //       return new HashSet<T>(list);
//    }
    /*1) У метод getUniqueMeasurableItems можна було передавати лише рядок номер 1 (відмічений коментарем) з методу main,
     а списки з рядків 2-4 (також відмічені коментарями)  !!! в завданні відсутня дія у фразі після ", а".  */

    //Відповідь на 1 питання кроку 2:
    public static <T extends MeasuredInKilograms> Set<T> getUniqueMeasurableItems(List<T> list) {
        // some specific processing to happen here
        return new HashSet<T>(list);
    }

    //Відповідь на 2 питання кроку 2:
    public static <T extends MeasuredInLiters> Set<T> getUniqueMeasurableItems(List<T> list) {
        // some specific processing to happen here
        return new HashSet<T>(list);
    }

    //Відповідь на 3 питання кроку 2:
    public static <T extends MeasuredInLiters> Set<T> getUniqueMeasurableItems(List<T> list) {
        // some specific processing to happen here
        return new HashSet<T>(list);
    }

    //Відповідь на 4 питання кроку 2:
    public static <T> Set<T> getUniqueMeasurableItems(List<T> list) {
        // some specific processing to happen here
        return new HashSet<T>(list);
    }

    private interface MeasuredInKilograms {}

    private static class Apple implements MeasuredInKilograms {}
    private static class WaterMelon implements MeasuredInKilograms {}
    private static class Tomato implements MeasuredInKilograms {}

    private interface Countable {}

    private static class Coin implements Countable {}
    private static class Toy implements Countable {}
    private static class Chair implements Countable {}

    private interface MeasuredInLiters {}

    private static class Water implements MeasuredInLiters {}
    private static class Juice implements MeasuredInLiters {}
    private static class Oil implements MeasuredInLiters {}

    private static class CanOfCoke implements Countable, MeasuredInLiters {}
    private static class BottleOfJuice implements Countable, MeasuredInLiters {}
    }
