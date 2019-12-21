package utils;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EnumUtil {
    /**
     * 将枚举转换为 Map，其中 key 是枚举名，value 是枚举本身。
     * 
     * @param enumClass
     * @return
     */
    public static <E extends Enum<E>> Map<String, E> getEnumMap(final Class<E> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants()).collect(Collectors.toMap(Enum::name, Function.identity()));
    }
}
