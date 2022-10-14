package Training.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int i;
        System.out.println("Для закінчення введи 0.");
        do {
            str = br.readLine();
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException e){
                System.out.println("Невірний формат");
                i = 0;
            }
            System.out.println("число: " + i + " в двоїчной формі " + Integer.toBinaryString(i));
            System.out.println("число: " + i + " в восьмірічній формі " + Integer.toOctalString(i));
            System.out.println("число: " + i + " в шістнадцьтирічній формі " + Integer.toHexString(i));
        } while (i != 0);
    }
}
