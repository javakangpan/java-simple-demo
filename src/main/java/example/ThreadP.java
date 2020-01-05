 package example;

 public class ThreadP extends Thread{
     
     private P p;
     
     public ThreadP(P p) {
         this.p = p;
    }
     
     @Override
    public void run() {
         for(int i = 0; i < 10; i++)
         p.setValue();
    }
}
