import java.time.LocalTime;

public class DelayedCheckin {

    public static final Object LOCK = new Object();

    public static void main(String[] args) {
        System.out.println(LocalTime.now() + ": Початок виконання");
        new Thread(() -> {
            synchronized (LOCK) {
                try {
                    LOCK.wait(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                checkIn();
            }
        }, "Потік-1").start();

        new Thread(() -> {
            synchronized (LOCK) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                checkIn();
            }
        }, "Потік-2").start();
    }

    private static void checkIn() {
        System.out.println(LocalTime.now() + ": " + Thread.currentThread().getName() + " зареєстровано");
    }
}
