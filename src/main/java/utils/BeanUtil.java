 package utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bean.Person;

public class BeanUtil {
     
     private static final Pattern  GET_PATTERN = Pattern.compile("get(\\p{javaUpperCase}\\w*)");
     
     /**
      * 获取对象的getter方法。
      * 
      * @param obj 对象
      * @return 对象的getter方法列表
      */

     public static List<Method> getGetterMethods(Object obj)
     {
         // getter方法列表
         List<Method> getterMethods = new ArrayList<Method>();
         // 获取所有方法
         Method[] methods = obj.getClass().getMethods();
         // 查找getter方法
         for (Method method : methods)
         {
             Matcher m = GET_PATTERN.matcher(method.getName());
             if (m.matches() && (method.getParameterTypes().length == 0))
             {
                 getterMethods.add(method);
             }
         }
         // 返回getter方法列表
         return getterMethods;
     }
     
     public static void main(String[] args) {
        Person person = new Person();
        BeanUtil.getGetterMethods(person).forEach(System.out::println);
    }

}
