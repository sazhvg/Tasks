package Training.Thread;

public class SuspendResume {
    public static void main(String[] args) {
        NewThread ob1 = new NewThread("Один");
        NewThread ob2 = new NewThread("Два");

        try {
            Thread.sleep(1000);
            ob1.mysuspend();
            System.out.println("Призупинка потоку Один");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Відновлення потоку Один");
            ob2.mysuspend();
            System.out.println("Призупинка потоку Два");
            Thread.sleep(1000);
            ob2.myresume();
            System.out.println("Відновлення потоку Два");
        } catch (InterruptedException e){
            System.out.println("Головний потік перервано");
        }

        // Очикувати завершення потоків віиконання
        try {
            System.out.println("Очікування завершення потоків.");
            ob1.t.join();
            ob2.t.join();
        }catch (InterruptedException e){
            System.out.println("Головний потік перервано");
        }
        System.out.println("Головний потік завершено");
    }
}
