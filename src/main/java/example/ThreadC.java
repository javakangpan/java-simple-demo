 package example;

 public class ThreadC extends Thread {
     private C c;
     public ThreadC(C c) {
         this.c = c;
     }
     
     @Override
    public void run() {
         for(int i = 0; i < 10; i++)
         c.getValue();
    }
}
