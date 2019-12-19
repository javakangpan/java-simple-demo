 package Application;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class LambdaSortApplication {
     
    public static void main(String[] args) {
        
        List<String> list = Arrays.asList("A","B","C","D","E","F");
        
        //老版本的Java中是如何排列字符串的
        Collections.sort(list, new Comparator<String>() {
                public int compare(String o1, String o2) {
                     return o1.compareTo(o2);
                }});
        
        //lambda表达式
        Collections.sort(list, (String a, String b) -> {
            return b.compareTo(a);
        });
        
        //写得更短
        Collections.sort(list, (String a, String b) -> b.compareTo(a));
        
        //更短点
        list.sort((a,b) -> b.compareTo(a));
        
        //老版本的Java
        for (String string : list) {
            System.out.println(string);
        }
        
        list.forEach(name -> {
            System.out.println(name);
        });
//        Iterable 接口forEach的实现        
//        default void forEach(Consumer<? super T> action) {
//            Objects.requireNonNull(action);
//            for (T t : this) {
//                action.accept(t);
//            }
//        }
        
    }
}
