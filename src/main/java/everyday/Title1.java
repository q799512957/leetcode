package everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * @author jijiahe
 * @version 1.0
 * @date 2022/9/5 15:21
 */
public class Title1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]) , i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
