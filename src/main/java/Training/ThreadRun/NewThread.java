package Training.ThreadRun;

public class NewThread extends Thread{
    boolean suspendFlag;
    NewThread(String threadName, ThreadGroup tgOb){
        super(tgOb, threadName);
        System.out.println("Новий поток: " + this);
        suspendFlag = false;
        start();
    }
    public void run(){
        try {
            for (int i =5; i > 0; i--){
                System.out.println(getName() + ": " + i);
                Thread.sleep(1000);
                synchronized (this){
                    while (suspendFlag){
                        wait();
                    }
                }
            }
        }catch (Exception e){
            System.out.println("Виключення в " + getName());
        }
        System.out.println(getName() + "завершується.");
    }
    synchronized void mysuspend(){
        suspendFlag = true;
    }
    synchronized  void myresume(){
        suspendFlag = false;
        notify();
    }
}
