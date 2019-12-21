package utils;


public class ClassUtil {

    /**
     * 此方法检查指定的类是内部类还是静态嵌套类。
     * @param cls
     * @return
     */
    public static boolean isInnerClass(final Class<?> cls) {
        return cls != null && cls.getEnclosingClass() != null;
    }
}
