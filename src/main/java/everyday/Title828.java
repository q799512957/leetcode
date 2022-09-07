package everyday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 统计子串中的唯一字符
 * todo 现在不正确
 * @author jijiahe
 * @version 1.0
 * @date 2022/9/6 10:31
 */
public class Title828 {

    public static int uniqueLetterString(String s) {
        char[] chars = s.toCharArray();
        int[] countUniqueChars = new int [chars.length];
        for (int i = 1; i <= chars.length; i++) {
            countUniqueChars[i - 1] = uniqueLetterString2(s.substring(0, i));
        }
       return Arrays.stream(countUniqueChars).sum();
    }
    public static int uniqueLetterString2(String s) {
            int sum = 0;
            for (int i = s.toCharArray().length - 1; i >=0; i--) {
                    sum = sum + uniqueLetterString3(s.substring(i));
            }
            return sum;
    }
    public static int uniqueLetterString3(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
                if (charMap.containsKey(chars[i])) {
                    sum --;
                } else {
                    sum ++;
                }
            charMap.put(chars[i], i);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(uniqueLetterString("LEETCODE"));
        // L E E T  C  O  D  E
        // 1 3 2 6  11  17 24 26
        // A B C
        // 1 3 6
        // A B A
        // 1 3 4
    }

}
