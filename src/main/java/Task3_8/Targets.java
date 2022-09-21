package Task3_8;

import java.time.LocalTime;
public class Targets {
    private int qty;
    private  double price;

    Targets (int qty, double price){
        this.qty = qty;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }

    public void stockPriceUpdate(String nameThread) {

        double pr = getPrice();
        setPrice(pr*(1+((Math.random()*6)-3)/100));// встановлення відхилення від -3% до 3%
        System.out.println(LocalTime.now() +  " Ціна акцій компанії " + nameThread +
                " змінилась. Поточна вартість: " + getPrice() + ".");
    }
}
