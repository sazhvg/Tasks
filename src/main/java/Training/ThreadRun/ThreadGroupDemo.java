package Training.ThreadRun;

public class ThreadGroupDemo {
    public static void main(String[] args) {
        ThreadGroup groupA = new ThreadGroup("Група А");
        ThreadGroup groupB = new ThreadGroup("Група В");

        NewThread ob1 = new NewThread("Один", groupA);
        NewThread ob2 = new NewThread("Два", groupA);
        NewThread ob3 = new NewThread("Три", groupA);
        NewThread ob4 = new NewThread("Чотири", groupA);

        System.out.println("\nВивід із методу list():");
        groupA.list();
        groupB.list();
        System.out.println();

        System.out.println("Переривається Група А");
        Thread tga[] = new  Thread[groupA.activeCount()];
        groupA.enumerate(tga);
        for (int i = 0; i < tga.length; i++) ((NewThread)tga[i]).mysuspend();
        try {
            Thread.sleep(4000);
        }catch (InterruptedException e){
            System.out.println("Головний потік виконання перевано.");
        }
        System.out.println("Відновлення Групи А");
        for (int i = 0; i < tga.length; i++) ((NewThread)tga[i]).myresume();

        try {
            System.out.println("Очікування завершення потоків виконання.");
            ob1.join();
            ob2.join();
            ob3.join();
            ob4.join();
        }catch (Exception e){
            System.out.println("Виключення в головному потоці виконання.");
        }
        System.out.println("Головний потік виконання завершено.");
    }
}
