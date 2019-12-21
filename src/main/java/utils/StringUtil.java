package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringUtil {

    /**
     * 以字节为单位返回字符串的长度。
     * 
     * @param input
     * @return
     */
    public static int byteSize(String input) {
        return input.getBytes().length;
    }

    /**
     * 将字符串首字母大写
     * 
     * @param input
     * @param lowerRest
     * @return
     */
    public static String capitalize(String input, boolean lowerRest) {
        return input.substring(0, 1).toUpperCase()
            + (lowerRest ? input.substring(1, input.length()).toLowerCase() : input.substring(1, input.length()));
    }

    /**
     * 将字符串中每个单词的首字母大写
     * 
     * @param input
     * @return
     */
    public static String capitalizeEveryWord(final String input) {
        return Pattern.compile("\\b(?=\\w)").splitAsStream(input).map(w -> capitalize(w, false))
            .collect(Collectors.joining());
    }

    /**
     * 转义要在正则表达式中使用的字符串。
     * 
     * @param input
     * @return
     */
    public static String escapeRegExp(String input) {
        return Pattern.quote(input);
    }

    /**
     * 检查字符串是否为小写。
     * 
     * @param input
     * @return
     */
    public static boolean isLowerCase(String input) {
        return Objects.equals(input, input.toLowerCase());
    }

    /**
     * 检查字符串是否为大写。
     * 
     * @param input
     * @return
     */
    public static boolean isUpperCase(String input) {
        return Objects.equals(input, input.toUpperCase());
    }

    /**
     * 判断一个字符串是否回文。
     * 
     * @param input
     * @return
     */
    public static boolean isPalindrome(String input) {
        String s = input.toLowerCase().replaceAll("[\\W_]", "");
        return Objects.equals(s, reverseString(input));
    }

    /**
     * 反转字符串。
     * 
     * @param input
     * @return
     */
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    /**
     * 检查字符串是否为数字。
     * 
     * @param input
     * @return
     */
    public static boolean isNumeric(final String input) {
        return IntStream.range(0, input.length()).allMatch(i -> Character.isDigit(input.charAt(i)));
    }

    /**
     * 用指定的掩码字符替换除最后 num 个字符以外的所有字符。
     * 
     * @param input
     * @param num
     * @param mask
     * @return
     */
    public static String mask(String input, int num, String mask) {
        int length = input.length();
        return num > 0 ? input.substring(0, length - num).replaceAll(".", mask) + input.substring(length - num)
            : input.substring(0, Math.negateExact(num))
                + input.substring(Math.negateExact(num), length).replaceAll(".", mask);
    }

    /**
     * 按字母顺序排列字符串中的字符。
     * 
     * @param input
     * @return
     */
    public static String sortCharactersInString(String input) {
        return Arrays.stream(input.split("")).sorted().collect(Collectors.joining());
    }
    
    /**
     * 转换一个字符串为驼峰式。
     * @param input
     * @return
     */
    public static String toCamelCase(String input) {
        Matcher matcher = Pattern.compile("[A-Z]{2,}(?=[A-Z][a-z]+[0-9]*|\\b)|[A-Z]?[a-z]+[0-9]*|[A-Z]|[0-9]+").matcher(input);
        List<String> matchedParts = new ArrayList<>();
        while (matcher.find()) {
            matchedParts.add(matcher.group(0));
        }
        String s = matchedParts.stream()
                .map(x -> x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase())
                .collect(Collectors.joining());
        return s.substring(0, 1).toLowerCase() + s.substring(1);
    }
}
