package everyday;

/**
 * 寻找两个正序数组的中位数
 * todo 二分查找法
 * @author jijiahe
 * @version 1.0
 * @date 2022/9/5 16:10
 */
public class Title4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        boolean flag = length % 2 == 0;
        int index = length / 2;
        int i = 0,j = 0;
        int a = 0, b = 0;
        int min = Integer.MIN_VALUE;
        if (nums1.length == 0 || nums2.length == 0) {
            if (nums1.length == 0) {
                return flag ? (double) (nums2[index - 1] + nums2[index]) / 2 : (double) nums2[index];
            } else {
                return flag ? (double) (nums1[index - 1] + nums1[index]) / 2 : (double) nums1[index];
            }

        }
        while ((i + j) <= index) {
            if (i == nums1.length) {
                min = nums2[j];
            } else if (j == nums2.length) {
                min = nums1[i];
            } else {
                min = Math.min(nums1[i], nums2[j]);
            }
            if (flag && (i + j) == index - 1) {
                b = min;
            }
            if ((i + j) == index) {
                a = min;
                break;
            }
            if(i == nums1.length || (j < nums2.length && nums1[i] > nums2[j])) {
                j++;
            } else {
                i++;
            }

        }
        return flag ? (double) (a + b) / 2 : (double) a;
    }

    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{2,3,4},new int[]{1});
    }
}
