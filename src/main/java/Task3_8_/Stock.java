package Task3_8_;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Stock implements Runnable{
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private String name;
    private  double price;
    private Thread t;

    public Thread getT() {
        return t;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    Stock(String name, double price){
        this.name = name;
        this.price = price;
    }
    synchronized public void stockPriceUpdate() {
        setPrice(price*(1+((Math.random()*6)-3)/100));// встановлення відхилення від -3% до 3%
        System.out.println(LocalTime.now().format(formatter) +  " Ціна акцій компанії " + name +
                " змінилась. Поточна вартість: " + getPrice() + ".");
    }
    public void priceUpdate(Boolean Flag) {
        t = new Thread(this, name);
        t.start();
    }
    public void run(){
        try {
            while (Exchange.Flag) {
                Thread.sleep(30000);
                stockPriceUpdate();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Акція " + name + "; вартість: " + price+".";
    }
}
