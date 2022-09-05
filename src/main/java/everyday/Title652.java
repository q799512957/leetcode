package everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 寻找重复的子树
 * @author jijiahe
 * @version 1.0
 * @date 2022/9/5 11:11
 */
public class Title652 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> treeNodes = new ArrayList<>();
        dfs(root, map, treeNodes);
        treeNodes.stream().distinct();
        return treeNodes;
    }

    public static String dfs(TreeNode root, Map<String, Integer> map, List<TreeNode> treeNodes) {
        if (root == null) {
            return "null";
        }
        StringBuffer str = new StringBuffer();
        str.append(root.val);
        str.append(",").append(root.left == null ? "null" : dfs(root.left, map, treeNodes));
        str.append(",").append(root.right == null ? "null" : dfs(root.right, map, treeNodes));
        if (map.containsKey(str.toString())) {
            if (map.get(str.toString()) == 1) {
                treeNodes.add(root);
            }
            map.put(str.toString(), map.get(str.toString()) + 1);

        } else {
            map.put(str.toString(), 1);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2, new TreeNode(1, new TreeNode(11), null), new TreeNode(11, new TreeNode(1), null));
        findDuplicateSubtrees(treeNode);
    }
}
