 package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class LambdaListOptionApplication {
     public static void main(String[] args) {
         List<String> stringList = new ArrayList<>();
         stringList.add("ddd2");
         stringList.add("aaa2");
         stringList.add("bbb1");
         stringList.add("aaa1");
         stringList.add("bbb3");
         stringList.add("ccc");
         stringList.add("bbb2");
         stringList.add("ddd1");
         
         stringList
         .stream()
         .filter((s) -> s.startsWith("a"))
         .forEach(System.out::println);//aaa2 aaa1
         
         // Sort (排序)
         stringList
         .stream()
         .sorted()
         .filter((s) -> s.startsWith("a"))
         .forEach(System.out::println);// aaa1 aaa2
         
         //不会影响原有的数据源
         System.out.println(stringList);// ddd2, aaa2, bbb1, aaa1, bbb3, ccc, bbb2, ddd1
         
         //中间操作 map 会将元素根据指定的 Function 接口来依次将元素转成另外的对象。
         //map返回的Stream类型是根据你map传递进去的函数的返回值决定的。
         stringList
         .stream()
         .map(String::toUpperCase)
         .sorted((a, b) -> b.compareTo(a))
         .forEach(System.out::println);// "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"
         
         
         // 测试 Match (匹配)操作
         boolean anyStartsWithA =
                 stringList
                         .stream()
                         .anyMatch((s) -> s.startsWith("a"));
         System.out.println(anyStartsWithA);      // true

         boolean allStartsWithA =
                 stringList
                         .stream()
                         .allMatch((s) -> s.startsWith("a"));

         System.out.println(allStartsWithA);      // false

         boolean noneStartsWithZ =
                 stringList
                         .stream()
                         .noneMatch((s) -> s.startsWith("z"));

         System.out.println(noneStartsWithZ);      // true
         
         //测试 Count (计数)操作
         long startsWithB =
                 stringList
                         .stream()
                         .filter((s) -> s.startsWith("b"))
                         .count();
         System.out.println(startsWithB);    // 3
         
         
         //测试 Reduce (规约)操作
         Optional<String> reduced =
                 stringList
                         .stream()
                         .sorted()
                         .reduce((s1, s2) -> s1 + "#" + s2);

         reduced.ifPresent(System.out::println);//aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2
         
      // 字符串连接，concat = "ABCD"
         String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat); 
         // 求最小值，minValue = -3.0
         double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min); 
         // 求和，sumValue = 10, 有起始值
         int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
         // 求和，sumValue = 10, 无起始值
         sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
         // 过滤，字符串连接，concat = "ace"
         concat = Stream.of("a", "B", "c", "D", "e", "F").
          filter(x -> x.compareTo("Z") > 0).
          reduce("", String::concat);
         
         
         int max = 1000000;
         List<String> values = new ArrayList<>(max);
         for (int i = 0; i < max; i++) {
             UUID uuid = UUID.randomUUID();
             values.add(uuid.toString());
         }
         
       //串行排序
         {
         long t0 = System.nanoTime();
         long count = values.stream().sorted().count();
         System.out.println(count);

         long t1 = System.nanoTime();

         long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
         System.out.println(String.format("sequential sort took: %d ms", millis));
         }
         
       //并行排序
         {
             long t0 = System.nanoTime();

             long count = values.parallelStream().sorted().count();
             System.out.println(count);

             long t1 = System.nanoTime();

             long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
             System.out.println(String.format("parallel sort took: %d ms", millis)); 
         }

    }
}
