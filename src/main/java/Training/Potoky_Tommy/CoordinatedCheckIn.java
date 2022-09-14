import java.time.LocalTime;

public class CoordinatedCheckIn {

    public static final Object LOCK = new Object();

    public static void coordinatedCheckIn() {
        try {
            synchronized (LOCK) {
                LOCK.wait();
                System.out.println(LocalTime.now() + ": " + Thread.currentThread().getName() + " зареєстровано");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(LocalTime.now() + ": Початок виконання");
        new Thread(CoordinatedCheckIn::coordinatedCheckIn, "Потік-1").start();
        new Thread(CoordinatedCheckIn::coordinatedCheckIn, "Потік-2").start();
        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (LOCK) {
                LOCK.notify();
            }
        }
    }
}
