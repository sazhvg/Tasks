package Training.MaxMin;

public class MaxMinValue {
    public static void main(String[] args) {

        int n = 1000;
        double[] array = new double[n];
        double [] min_avg_max = {1, 0, 0}; // Массив не должен быть пустым

        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
            if(min_avg_max[0] > array[i])
                min_avg_max[0] = array[i];
            if(min_avg_max[2] < array[i])
                min_avg_max[2] = array[i];
            min_avg_max[1]+=array[i];
        }
        min_avg_max[1]=min_avg_max[1]/array.length;

        System.out.println("min = " + min_avg_max[0]);
        System.out.println("avg = " + min_avg_max[1]);
        System.out.println("max = " + min_avg_max[2]);
    }

}
