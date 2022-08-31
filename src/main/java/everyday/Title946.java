package everyday;

/**
 * 验证栈序列
 * @author jijiahe
 * @version 1.0
 * @date 2022/8/31 10:32
 */
public class Title946 {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        int poppedIndex = 0,pushedIndex = 0;
        int index = 0 ;
        while (pushedIndex < pushed.length) {
            pushed[index] = pushed[pushedIndex];
            while (index >= 0 && popped[poppedIndex] == pushed[index]) {
                index --;
                poppedIndex ++ ;
            }
            pushedIndex++;
            index ++;
        }
        return poppedIndex == popped.length ? true : false;
    }

    public static void main(String[] args) {
        validateStackSequences(new int[] {0,1}, new int[] {0,1});
    }
}
