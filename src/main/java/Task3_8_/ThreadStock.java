package Task3_8_;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ThreadStock extends Thread{

    private static LocalTime time = LocalTime.now(); // Gets the current time
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private Account a;
    static List<ThreadStock> t = new ArrayList<>();// список потоків для контролю зупинки

    ThreadStock(Account account) {
        super(account.getName());
        a = account;
        start();
    }

    public void run() {
        try {
            t.add(this);
            while (Exchange.Flag) {
                transaction();
                sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void transaction(){

        Target tBuyer, tTreder;
        Stock stock;

        HashMap <String, Stock> mapStock;
        mapStock = Exchange.getStocksMap();//отримати список акцій на біржі для отримання поточної вартості

        HashMap <String, Target> mapTarget,mapTransaction;
        mapTarget = a.getTargetsBuy(); //отримати поточний список заявок покупця
        mapTransaction = a.getTransaction();

        HashMap <String, Target> mapSeller;
        mapSeller = Exchange.getAccountsMap().get("Trader").getTargetsSeller();//отримати поточний список придбаних акцій

        for (String key: mapTarget.keySet()){
            tBuyer = mapTarget.get(key);
            stock = mapStock.get(key);
            tTreder = mapSeller.get(key);

            double priceStock = stock.getPrice();//отримати поточну вартість акцій на біржі
            double priceBuyer = tBuyer.getPrice();//отримати вартість акцій у Покупця

        //якщо  вартість покупця не нижче вартості на біржі, то провести транзакцію та внести зміни до списків продавця, покупця та транзакцій
            if (priceBuyer>=priceStock){
                int qtyBuyer = tBuyer.getQty();
                int qtyTrader = tTreder.getQty();
                int qtyTransaction = qtyBuyer>qtyTrader? qtyTrader: qtyBuyer;
                if (qtyTransaction>0){
                    tBuyer.setQty(qtyBuyer-qtyTransaction);
                    tTreder.setQty(qtyTrader-qtyTransaction);
                    mapTransaction.put(key, new Target(qtyTransaction, priceStock));
                    System.out.println(time.format(formatter) + " Спроба купівлі акції "
                            + key + " для "+ a.getName() +" успішна. Куплено " + qtyTransaction + " за ціною "
                            + priceStock + ".");
                }
            }
        }
    }
}
