package example;

public class ApplicationOfPCDemo {
    public static void main(String[] args)  {
        String  lockString = "lock";
        P p = new P(lockString);
        C c = new C(lockString);
        ThreadP p2 = new ThreadP(p);
        ThreadC c2 = new ThreadC(c);
        p2.start();
        c2.start();
    }
}
