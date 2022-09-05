package everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * @author jijiahe
 * @version 1.0
 * @date 2022/9/5 15:57
 */
public class Title3 {
    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.equals("")) {
            return 0;
        }
        int maxCount = 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                maxCount = Math.max(map.size(), maxCount);
                i = map.get(chars[i]);
                map.clear();
            } else {
                map.put(chars[i], i);
            }
        }
        maxCount = Math.max(map.size(), maxCount);
        return maxCount;
    }
}
