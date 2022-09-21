package Task3_8;

import java.time.LocalTime;
import java.util.HashMap;

public class Exchange {
    private static HashMap <String, Targets> targetsMap; // Перелік завдань

    public static void main(String[] args) {
        int millisSec= 10*60*1000; // Час торгівлі

        targetsMap = new HashMap<>();                       // Перелік акцій до продажу
        targetsMap.put("AAPL", new Targets(100, 141.0));
        targetsMap.put("COKE", new Targets(1000, 387.0));
        targetsMap.put("IBM", new Targets( 200, 137.0));
        Account Stock = new Account("Stock", false, targetsMap);

        targetsMap = new HashMap<>();                       // Перелік заявок на покупку Alice
        targetsMap.put("COKE", new Targets(20, 390.0));
        targetsMap.put("AAPL", new Targets(10, 100.0));
        Account Alice = new Account("Alice", true, targetsMap);

        targetsMap = new HashMap<>();                       // Перелік заявок на покупку Bob
        targetsMap.put("AAPL", new Targets(10, 140.0));
        targetsMap.put("IBM", new Targets(20, 135.0));
        Account Bob = new Account("Bob", true, targetsMap);

        targetsMap = new HashMap<>();                       // Перелік заявок на покупку Charlie
        targetsMap.put("COKE", new Targets(300, 370.0));
        Account Charlie = new Account("Charlie",true, targetsMap);

        try {
            System.out.println("Початок торгівлі :" + LocalTime.now());
            Account.setFlag(true);
            // Запуск потоків
            Stock.accountStart();
            Account.setStock(Stock.getTargetsMap());
            Alice.accountStart(true); //параметр далі ніде не використовується, включений для перезавантаженого методу
            Bob.accountStart(true); // --/--
            Charlie.accountStart(true); // --/--

            Thread.sleep(millisSec);
            Account.setFlag(false);
            System.out.println("Торгівля завершена :"  + LocalTime.now());
            System.out.println("Вартість акцій на момент завершення торгів:");
            targetsMap =  Stock.getTargetsMap();
            for (String key: targetsMap.keySet()){
                System.out.println( "Вартість акцій " + key + " становить: " + targetsMap.get(key).getPrice());
            }
//                o.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
