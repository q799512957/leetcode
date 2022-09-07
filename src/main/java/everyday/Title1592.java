package everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 重新排列单词间的空格
 * @author jijiahe
 * @version 1.0
 * @date 2022/9/7 11:46
 */
public class Title1592 {

    public static String reorderSpaces(String text) {
        String[] split = text.trim().split("\\s+");
        int allSpaceCount = text.length();
        for (int i = 0; i < split.length; i++) {
            allSpaceCount = allSpaceCount - split[i].length();
        }
        if (allSpaceCount == 0 || split.length == 0) {
            return text;
        }
        if (split.length == 1) {
            String spaceStr = "";
            for (int i = 0; i < allSpaceCount; i++) {
                spaceStr = spaceStr + " ";
            }
            return split[0] + spaceStr;
        }
        int space = allSpaceCount/(split.length - 1);
        String spaceStr = "";
        for (int i = 0; i < space; i++) {
            spaceStr = spaceStr + " ";
        }
        int otherSpace = allSpaceCount%(split.length - 1);
        String otherSpaceStr = "";
        for (int i = 0; i < otherSpace; i++) {
            otherSpaceStr = otherSpaceStr + " ";
        }
        String str = "";
        for (int i = 0; i < split.length; i++) {
            if (i == split.length - 1) {
                str = str + split[i];
            } else {
                str = str + split[i] + spaceStr;
            }
        }
        str = str + otherSpaceStr;
        return str;
    }

    public static void main(String[] args) {
        reorderSpaces2("hello   world");
    }

    public static String reorderSpaces2(String text) {
        List<String> list = new ArrayList<>();

        int allSpaceCount = 0;
        char[] chars = text.toCharArray();
        for (int l = 0, r = 0; r < chars.length; r++) {
            if (chars[r] == ' ') {
                allSpaceCount ++;
                if (chars[l] != ' ') {
                    list.add(text.substring(l, r));
                    l = r;
                }
                l ++;
            }
            if (r == chars.length - 1 && chars[r] != ' ') {
                list.add(text.substring(l, chars.length));
            }
        }
        if (allSpaceCount == 0) {
            return text;
        }
        if (list.size() == 1) {
            String spaceStr = "";
            for (int i = 0; i < allSpaceCount; i++) {
                spaceStr = spaceStr + " ";
            }
            return list.get(0) + spaceStr;
        }
        int space = allSpaceCount/(list.size() - 1);
        String spaceStr = "";
        for (int i = 0; i < space; i++) {
            spaceStr = spaceStr + " ";
        }
        int otherSpace = allSpaceCount%(list.size() - 1);
        String otherSpaceStr = "";
        for (int i = 0; i < otherSpace; i++) {
            otherSpaceStr = otherSpaceStr + " ";
        }
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                str = str + list.get(i);
            } else {
                str = str + list.get(i) + spaceStr;
            }
        }
        str = str + otherSpaceStr;
        return str;
    }
}
