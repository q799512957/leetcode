package everyday;

import java.util.Arrays;
import java.util.Deque;
import java.util.TreeMap;

/**
 * 最大交换
 * @author jijiahe
 * @version 1.0
 * @date 2022/9/13 17:06
 */
public class Title670 {

    public static int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        char[] chars2 = Arrays.copyOf(chars, chars.length);
        Arrays.sort(chars2);
        int i1 = 0;
        int i2 = 0;
        char c = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i1 == 0 && chars[i] != chars2[chars.length - 1 - i]) {
                i1 = Integer.parseInt(chars2[chars.length - 1 - i] + "") - Integer.parseInt(chars[i] + "");
                num = num + i1 * (int) Math.pow(10, chars.length - 1 - i);
                c = chars2[chars.length - 1 - i];
            }
            if (chars[i] == c) {
                i2 = chars.length - 1 - i;
            }
        }
        return num - i1 * (int) Math.pow(10, i2);
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(2736));
    }
}
