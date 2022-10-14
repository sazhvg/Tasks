package Task3_7.Task3_7_1;

public interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}

/*
    Formula formula = new Formula() {
        @Override
        public double calculate(int a) {
            return sqrt(a * 100);
        }
    };

    formula.calculate(100);     // 100.0
    formula.sqrt(16);                // 4.0

 */

/*
List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");


Вариант 1
Collections.sort(names, new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return b.compareTo(a);
    }
});
Вариант 2
Collections.sort(names, (String a, String b) -> {
    return b.compareTo(a);
});
Вариант 3
Collections.sort(names, (String a, String b) -> b.compareTo(a));
Вариант 4
Collections.sort(names, (a, b) -> b.compareTo(a));
 */
// Добавление аннотации
@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}
/*    Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
    Integer converted = converter.convert("123");
System.out.println(converted);    // 123*/