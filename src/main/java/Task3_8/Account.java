package Task3_8;

import Task3_6.SaferException;

import java.time.LocalTime;
import java.util.HashMap;

public class Account implements Runnable {

    private String name; //Ім'я власника рахунку

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private boolean buy; //Тип покупця(true)/продавця(false)
    public static HashMap<String, Targets> stock; //Зроблено коряво, но по іншому не зміг, посилання на список продаж для методуstockBuyer
    public static void setStock(HashMap<String, Targets> stock) {
        Account.stock = stock;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    private HashMap<String, Targets> targetsMap; // Перелік продажів (потоків)
    private HashMap<String, Targets> buyMap =new HashMap<>(); // Перелік придбань

    public HashMap<String, Targets> getBuyMap() {
        return buyMap;
    }

    public void setTargetsMap(HashMap<String, Targets> targetsMap) {
        this.targetsMap = targetsMap;
    }

    public HashMap<String, Targets> getTargetsMap() {
        return targetsMap;
    }

    private static Boolean Flag;
    public static void setFlag(Boolean flag) {
        Flag = flag;
    }
    public static final Object LOCK = new Object();

    public Account(String name, boolean buy, HashMap<String, Targets> targetsMap) {
        this.name = name;
        this.buy = buy;
        this.targetsMap = targetsMap;
    }

//Утворення потоків, які обслуговують окремо свою акцію.

    public void accountStart() {
        for (String nameThread : targetsMap.keySet()) {
            Targets t = targetsMap.get(nameThread);
            new Thread(() -> {
                try {
                    while (Flag) {
                        synchronized (t) {
                            t.stockPriceUpdate(nameThread);
                            t.wait(30000);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, nameThread).start();
        }
    }

    //Утворення потоків, які обслуговують покупця.
    public void accountStart(boolean flag) {
        Thread t = new Thread(this, name);
        t.start();// Запустити потік виконання
    }
    public void run() {
        try {
            while (Flag){
                stockBuyer(name, targetsMap);
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " перевано.");
        }
        System.out.println("Потік " + name +" завершено. Придбано:");
        for (String key: buyMap.keySet()){
            System.out.println( "   акції: " + key + "; кількість: " + buyMap.get(key).getQty()
                    + "; за ціною: " + buyMap.get(key).getPrice());
        }
    }

    private void stockBuyer(String name ,HashMap <String, Targets> targets) {

        Targets tBuyer, tStock;

        for (String key: targets.keySet()){
            tBuyer = targets.get(key);
            tStock = stock.get(key);
            int qtyStock = tStock.getQty();
            double priceStock = tStock.getPrice();
            int qtyBuyer = tBuyer.getQty();
            if (tBuyer.getPrice()>=priceStock){
                int qtyTransaction = qtyBuyer>qtyStock? qtyStock: qtyBuyer;
                if (qtyTransaction>0){
                    tBuyer.setQty(qtyBuyer-qtyTransaction);
                    tStock.setQty(qtyStock-qtyTransaction);
                    buyMap.put(key, new Targets(qtyTransaction, priceStock));
                    System.out.println(LocalTime.now() + " Спроба купівлі акції "
                            + key + " для "+ name +" успішна. Куплено " + qtyTransaction + "акцій за ціною "
                            + tStock.getPrice()+".");
                }
            }
        }
    }
}
