package utils;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayUtil {

    /**
     * 将数组分割成特定大小的小数组。
     * 
     * @param numbers
     * @param size
     * @return
     */
    public static int[][] chunk(int[] numbers, int size) {

        return IntStream.iterate(0, i -> i + size).limit((long)Math.ceil((double)numbers.length / size))
            .mapToObj(
                cur -> Arrays.copyOfRange(numbers, cur, cur + size > numbers.length ? numbers.length : cur + size))
            .toArray(int[][]::new);
    }

    /**
     * 拼接
     * 
     * @param first
     * @param second
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] concat(T[] first, T[] second) {
        return Stream.concat(Stream.of(first), Stream.of(second))
            .toArray(i -> (T[])Arrays.copyOf(new Object[0], i, first.getClass()));
    }

    /**
     * 计算数组中某个值出现的次数
     * 
     * @param numbers
     * @param value
     * @return
     */
    public static long countOccurrences(int[] numbers, int value) {
        return Arrays.stream(numbers).filter(number -> number == value).count();
    }

    /**
     * 数组扁平化。
     * 
     * 使用递归实现，Arrays.stream().flatMapToInt()
     * 
     * @param input
     * @return
     */
    public static int[] deepFlatten(Object[] input) {
        return Arrays.stream(input).flatMapToInt(o -> {
            if (o instanceof Object[]) {
                return Arrays.stream(deepFlatten((Object[])o));
            }
            return IntStream.of((Integer)o);
        }).toArray();
    }

    /**
     * 返回两个数组之间的差异。
     * 
     * 从 b 中创建一个集合，然后在 a 上使用 Arrays.stream().filter() 只保留 b 中不包含的值
     * 
     * @param first
     * @param second
     * @return
     */
    public static int[] difference(int[] first, int[] second) {
        Set<Integer> set = Arrays.stream(second).boxed().collect(Collectors.toSet());
        return Arrays.stream(first).filter(v -> !set.contains(v)).toArray();
    }

    /**
     * 从比较器函数不返回true的数组中筛选出所有值。
     * 
     * int的比较器是使用IntbinaryPerator函数来实现的。
     * 
     * 使用 Arrays.stream().filter() 和 Arrays.stream().noneMatch() 查找相应的值。
     * 
     * @param first
     * @param second
     * @param comparator
     * @return
     */
    public static int[] differenceWith(int[] first, int[] second, IntBinaryOperator comparator) {
        return Arrays.stream(first).filter(a -> Arrays.stream(second).noneMatch(b -> comparator.applyAsInt(a, b) == 0))
            .toArray();
    }

    /**
     * 返回出现在两个数组中的元素数组。
     * 
     * 使用 Arrays.stream().filter() 移除，然后使用 Arrays.stream().anyMatch() 匹配 second 部分的值。
     * 
     * @param first
     * @param second
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] similarity(T[] first, T[] second) {
        return Arrays.stream(first).filter(a -> Arrays.stream(second).anyMatch(b -> Objects.equals(a, b)))
            // Make a new array of first's runtime type, but empty content:
            .toArray(i -> (T[])Arrays.copyOf(new Object[0], i, first.getClass()));
    }

    /**
     * shuffle 将数组值的顺序随机化，返回一个新数组。
     * 
     * 根据 Fisher-Yates 算法 重新排序数组的元素。
     * 
     * @param input
     * @return
     */
    public static <T> T[] shuffle(T[] input) {
        T[] arr = Arrays.copyOf(input, input.length);
        int length = arr.length;
        int m = length;
        while (m > 0) {
            int i = (int)Math.floor(Math.random() * m--);
            T tmp = arr[i];
            arr[i] = arr[m];
            arr[m] = tmp;
        }
        return arr;
    }

}
