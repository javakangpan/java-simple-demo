 package Application;

import Interface.Converter;

/**
    * 方法和构造函数引用(Method and Constructor References)
    * 函数式接口(Functional Interfaces)
  * @see java.util.concurrent.Callable
  */
 public class ConverterApplication implements Converter<String, Integer> {

    @Override
    public Integer convert(String from) {
        // return Integer.parseInt(from);
        return Integer.valueOf(from);
    }
    
    
    public static void main(String[] args) {
        
        ConverterApplication converterApplication = new ConverterApplication();
        System.out.println(converterApplication.convert("12"));
        
        
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted.getClass()); 
        
        Converter<String, Integer> converter01 = Integer::valueOf;
        Integer converted01 = converter01.convert("123");
        System.out.println(converted01.getClass()); 
        
        Something something = new Something();
        //Java 8允许您通过::关键字传递方法或构造函数的引用
        Converter<String, String> converter02 = something::startsWith;
        String converted02 = converter02.convert("Java");
        System.out.println(converted02); 
        
        //访问局部变量
        //num隐性的具有final
        //final int num = 1;
        int num = 1;
        Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);

        stringConverter.convert(2);     // 3
        //在lambda表达式中试图修改num同样是不允许的。
        //num = 3;
    }
}
 class Something {
     String startsWith(String s) {
         return String.valueOf(s.charAt(0));
     }
 }
