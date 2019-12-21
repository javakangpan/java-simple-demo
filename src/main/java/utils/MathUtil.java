package utils;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class MathUtil {

    public static <T extends Number & Comparable<? super T>> T min(T[] values) {
        if (values == null || values.length == 0)
            return null;
        T min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (min.compareTo(values[i]) > 0)
                min = values[i];
        }
        return min;
    }

    /**
     * 返回两个或两个以上数字的平均值。
     * 
     * @param arr
     * @return
     */
    public static double average(int[] arr) {
        return IntStream.of(arr).average().orElseThrow(() -> new IllegalArgumentException("Array is empty"));
    }

    /**
     * 检查数字是否是偶数。
     * 
     * 这个方法使用按位运算符，0b1 是1的二进制表示。 因为Java 7可以通过用 0b 或 0B 作为前缀来编写二进制文字。 数字为偶数时，＆ 运算符将返回0。 例如，IsEven(4) 会导致 100 & 001，＆的结果将是
     * 000。
     * 
     * @param value
     * @return
     */
    public static boolean isEven(final int value) {
        return (value & 0b1) == 0;
    }

    /**
     * 检查一个值是2的正幂。
     * 
     * 为了理解它是如何工作的，让我们假设我们调用了 IsPowerOfTwo(4)。
     * 
     * 当值大于0时，将评估 && 运算符的右侧。
     * 
     * (~value + 1) 的结果等于值本身，~100 + 001 => 011 + 001 => 100。
     * 
     * (value & value) 的结果是value，100 & 100 => 100.。
     * 
     * 当值等于值时，这将把值表达为真值。
     * 
     * @param value
     * @return
     */
    public static boolean isPowerOfTwo(final int value) {
        return value > 0 && ((value & (~value + 1)) == value);
    }
    
    /**
     * 生成一个介于 Integer.MIN_VALUE 和 Integer.MAX_VALUE 之间的随机数。
     * @return
     */
    public static int generateRandomInt() {
        return ThreadLocalRandom.current().nextInt();
    }
}
