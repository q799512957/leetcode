package everyday;

import java.util.TreeMap;

/**
 * 删除某些元素后的数组均值
 * @author jijiahe
 * @version 1.0
 * @date 2022/9/14 10:35
 */
public class Title1619 {

    public double trimMean(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.containsKey(arr[i]) ? map.get(arr[i]) + 1 : 1);
            sum += arr[i];
        }
        int num = (int)(arr.length * 0.05);
        int realLength = arr.length - num * 2;
        while (num > 0) {
            sum -= map.lastKey();
            if (map.get(map.lastKey()) == 1) {
                map.pollLastEntry();
            } else {
                map.put(map.lastKey(), map.get(map.lastKey()) - 1);
            }
            sum -= map.firstKey();
            if (map.get(map.firstKey()) == 1) {
                map.pollFirstEntry();
            } else {
                map.put(map.firstKey(), map.get(map.firstKey()) - 1);
            }
            num--;
        }
        return (double) sum / realLength;
    }
}
