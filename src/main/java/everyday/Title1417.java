package everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 重新格式化字符串
 * @author jijiahe
 * @version 1.0
 * @date 2022/8/11 11:28
 */
public class Title1417 {

    //todo 先放哪个
    public static String reformat(String s) {
        char [] cs = s.toCharArray();
        int index = 0;
        boolean flag = true;
        int i = 0;
        for (; i < cs.length; i++) {
            if ((flag && cs[i] > '9') || (!flag && cs[i] <= '9')) {
               ;
            } else {
                if ((index + 1) != i) {
                    char tmp = cs[i];
                    cs[i] = cs[index + 1];
                    cs[index + 1] = tmp;
                    i = index + 1;
                }
                flag = cs[i] > '9';
                index = i;
            }
        }
        return i == (index + 1) ? String.valueOf(cs) :"";
    }

    public static String reformat2(String s) {
        char [] cs = s.toCharArray();
        List<Character> num = new ArrayList<>();
        List<Character> str = new ArrayList<>();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] > '9') {
                str.add(cs[i]);
            } else {
                num.add(cs[i]);
            }
        }
        char [] re = new char[cs.length];
        if (Math.abs(num.size() - str.size()) > 1) {
            return "";
        }
        boolean flag = num.size() > str.size();
        for (int i = 0; i < re.length; i++) {
            if (flag) {
                re[i] = num.get(0);
                num.remove(0);
            } else {
                re[i] = str.get(0);
                str.remove(0);
            }
            flag = !flag;
        }
        return String.valueOf(re);
    }

    public static void main(String[] args) {
        reformat2("ab123");
    }
}
