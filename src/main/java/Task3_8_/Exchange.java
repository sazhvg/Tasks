package Task3_8_;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Exchange {

    static Boolean Flag;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static HashMap <String, Stock> stocksMap = new HashMap<>(); // Перелік акцій на біржі
    private static HashMap <String, Account> accountsMap = new HashMap<>(); // Перелік учасників біржі
    public static HashMap<String, Account> getAccountsMap() {
        return accountsMap;
    }
    public static HashMap<String, Stock> getStocksMap() {
        return stocksMap;
    }

    public static void main(String[] args) {
        int millisSec= 10*60*1000; // Час торгівлі

        // Перелік акцій на біржі та поточна вартість
        stocksMap.put("AAPL", new Stock("AAPL", 141.0));
        stocksMap.put("COKE", new Stock("COKE",387.0));
        stocksMap.put("IBM", new Stock("IBM", 137.0));

        accountsMap.put("Alice", new Account("Alice"));
        accountsMap.put("Bob", new Account("Bob"));
        accountsMap.put("Charlie", new Account("Charlie"));
        accountsMap.put("Trader", new Account("Trader"));

        // Перелік заявок на купівлю (покупців)
        HashMap <String, Target> temp;
        temp = accountsMap.get("Alice").getTargetsBuy();
        temp.put("AAPL", new Target(10, 100.0));
        temp.put("COKE", new Target(20, 390.0));

        temp = accountsMap.get("Bob").getTargetsBuy();
        temp.put("AAPL", new Target(10, 140.0));
        temp.put("IBM", new Target(20, 135.0));

        temp = accountsMap.get("Charlie").getTargetsBuy();
        temp.put("COKE", new Target(300, 370.0));

        // Перелік заявок на продаж (продавець)
        temp = accountsMap.get("Trader").getTargetsSeller();
        temp.put("AAPL", new Target(100));
        temp.put("COKE", new Target(1000));
        temp.put("IBM", new Target(200));

        try {
            System.out.println("Початок торгівлі :" + LocalTime.now().format(formatter));
            Flag =  true;
            // Запуск потоків
            for (Stock i: stocksMap.values()) i.priceUpdate(Flag);
            for (Account i: accountsMap.values()) new ThreadStock(i);

            Thread.sleep(millisSec);
            Flag = false;
            for (Stock i: stocksMap.values()) i.getT().join(); //очікування завершення другорядних потоків
            for (Thread i: ThreadStock.t) i.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Торгівля завершена :"  + LocalTime.now().format(formatter) + ".\n"
                +"Вартість акцій на момент завершення торгів:");
        for (Stock i: stocksMap.values()) System.out.println(i);
        System.out.println("Результати торгів:");
        for (Account i: accountsMap.values()) System.out.print(i.zvit());
    }
}

/*        За допомогою засобів багатопоковості розроби програму - симулятор біржі.

        Вхідні значення задаються в коді і описують акції, які торгуються на біржі:

        {"name":"AAPL", "amount":"100", "price":"141"}
        {"name":"COKE", "amount":"1000", "price":"387"}
        {"name":"IBM", "amount":"200", "price":"137"}

        Разом із цим задаються параметри покупців:
        {"name":"Alice",
        "target": [
        {"name":"AAPL", "amount":"10", "price":"100"},
        {"name":"COKE", "amount":"20", "price":"390"}
        ]}

        {"name":"Bob",
        "target": [
        {"name":"AAPL", "amount":"10", "price":"140"},
        {"name":"IBM", "amount":"20", "price":"135"}
        ]}

        {"name":"Charlie",
        "target": [
        {"name":"COKE", "amount":"300", "price":"370"}
        ]}

        Акції кожної з компаній має обслуговувати окремий потік біржі, який раз на 30 секунд
        має змінювати ціну на акції випадковим чином у межах 3% (в будь-яку сторону).

        Кожного покупця обслуговує також окремий потік-брокер, який має безпечно зврнутися до
        даних по поточній ціні акції і з огляду на налаштування покупця здійснити покупку
        необхідної кількості акції, або продовжити чекати. Потоки покупців мають робити спроби
        купівлі що 5 секунд.

        Кожен з потоків (і біржеві потоки, і брокерські) має на кожному кроці звітувати свої
        результати в консоль.

        Наприклад:

        2021-09-29 12:56:11 Ціна акцій компанії AAPL змінилась. Поточна вартість: 98.31
        ...

        2021-09-29 12:57:10 Спроба купівлі акції AAPL для Alice успішна. Куплено 20 акцій.
        2021-09-29 12:57:12 Спроба купівлі акції IBM для Bob не успішна.
        Біржа працює 10 хвилин. В кінці виводиться фінальна статистика - вартість акції всіх
        компанії при закритті біржі, та результати купівлі кожного з покупців.*/
