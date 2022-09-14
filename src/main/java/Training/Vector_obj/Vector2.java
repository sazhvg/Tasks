package Training.Vector_obj;

public class Vector2 {
    // теперь не три координаты, а массив координат
    private double values[];

    public Vector2(double[] values) {
        this.values = values;
    }

    // Длина вектора. Корень из суммы квадратов
    public double length() {
        double sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i] * values[i];
        }
        return Math.sqrt(sum);
    }

    // метод, вычисляющий скалярное произведение
    public double scalarProduct(Vector2 vector) {
        double res = 0;

        for (int i = 0; i < values.length; i++) {
            res += values[i] * vector.values[i];
        }
        return res;
    }

    // для многомерных не определено
    //    public double crossProduct(Vector vector) {
    //
    //    }

    // Косинус между двумя векторами
    public double cos(Vector2 vector) {
        return scalarProduct(vector) / (length() * vector.length());
    }

    public Vector2 add(Vector2 vector) {
        double[] another = new double[values.length];

        for (int i = 0; i < values.length; i++) {
            another[i] = values[i] + vector.values[i];
        }
        return new Vector2(another);
    }

    public Vector2 subtract(Vector2 vector) {
        double[] another = new double[values.length];

        for (int i = 0; i < values.length; i++) {
            another[i] = values[i] - vector.values[i];
        }
        return new Vector2(another);
    }

    // Вспомогательный метод
    private static double[] generateRandomArray(int length) {
        double[] array = new double[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }
        return array;
    }

    public static Vector2[] generate(int n, int dimension) {
        Vector2[] vectors = new Vector2[n];
        for (int i = 0; i < n; i++) {
            vectors[i] = new Vector2(generateRandomArray(dimension));
        }
        return vectors;
    }

}
