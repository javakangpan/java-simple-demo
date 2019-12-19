 package Application;

import Interface.Formula;

public class FormulaApplication implements Formula{

    @Override
    public double calculate(int a) {
         return sqrt(a * 1000);
    }

    public static void main(String[] args) {
        
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        
        System.out.println(formula.calculate(100));    
        System.out.println(formula.sqrt(16));  
        //为啥不能访问静态方法
        //formula..parseMoney(100L);
        System.out.println(Formula.parseMoney(100L));
    }
    
    
}
