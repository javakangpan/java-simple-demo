 package example;


public class ThreadGroupEnumerateExp {
     public static void main(String[] args) {
        ThreadGroup g1 = new ThreadGroup("parent thread");
        ThreadGroup g2 = new ThreadGroup(g1,"child thread");
        
        NewThread t1 = new NewThread("Thread-1", g1);
        System.out.println("starting of thread-1");
        t1.start();
        
        NewThread t2 = new NewThread("Thread-2", g1);
        System.out.println("starting of thread-2");
        t2.start();
        
        Thread[] arrayThreads = new Thread[g1.activeCount()];
        int count = g1.enumerate(arrayThreads);
        
        for (int i = 0; i < count; i++) {
            System.out.println(arrayThreads[i].getName() + "fount");
        }
    }
}
class NewThread extends Thread {
    NewThread(String threadname, ThreadGroup tg) {
        super(tg,threadname);
    }
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(
                    Thread.currentThread().getName()
                    + "interruped");
            }
        }
    }
}
 
