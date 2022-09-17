package Training.Thread;

public class NewThread implements Runnable{

    String name; //Ім'я потока
    Thread t;
    boolean suspendFlag;

    NewThread(String threadName){
        name=threadName;
        t=new Thread(this, name);
        System.out.println("Новий потік: " + t);
        suspendFlag=false;
        t.start();// Запустити потік виконання
    }

    // Точка входу в потік виконання
    public void run(){
        try {
            for (int i=15; i>0; i--){
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag){
                        wait();
                    }
                }
            }
        }catch (InterruptedException e){
            System.out.println(name + " перевано.");
        }
        System.out.println(name + " завершено.");
    }
    synchronized void mysuspend(){
        suspendFlag = true;
    };
    synchronized void myresume(){
        suspendFlag = false;
        notify();
    }
}
