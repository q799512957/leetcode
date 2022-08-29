package everyday;

/**
 * 重新排列数组
 *
 * @author jijiahe
 * @version 1.0
 * @date 2022/8/29 16:19
 */
public class Title1470 {

    public int[] shuffle(int[] nums, int n) {
        int [] numsall = new int[nums.length];
        for (int i = 0; i < n; i++) {
            numsall[i * 2] = nums[i];
            numsall[(i * 2) + 1] = nums [i + n];
        }
        return numsall;
    }
}
