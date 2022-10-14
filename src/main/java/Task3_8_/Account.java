package Task3_8_;

import java.util.HashMap;

public class Account {

    private String name; //Ім'я власника рахунку
    private HashMap<String, Target> targetsBuy = new HashMap<>(); // Перелік заявок на купівлю (покупець)
    private HashMap<String, Target> targetsSeller = new HashMap<>(); // Перелік заявок на продаж (продавець)
    private HashMap<String, Target> transaction = new HashMap<>(); // Перелік укладених угод

    public HashMap<String, Target> getTargetsBuy() {
        return targetsBuy;
    }
    public HashMap<String, Target> getTargetsSeller() {
        return targetsSeller;
    }
    public HashMap<String, Target> getTransaction() {
        return transaction;
    }

    public String getName() {
        return name;
    }

    public Account(String name) {
        this.name = name;
    }

    public String zvit(){

        String msg ="";
        if (transaction.size()>0){
            msg = name + " придбано:\n";
            Target t;
            for (String i: transaction.keySet()){
                t = transaction.get(i);
                msg = msg + i + " в кількості - " + t.getQty() + ", за ціною: " + t.getPrice() + "\n";
            }
        }
        return msg;
    }
}
