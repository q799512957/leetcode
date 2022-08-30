package everyday;

/**
 * 最大二叉树 II
 * 垃圾题目 没读懂 最后通过尝试可知
 * 只需遍历右树找到比val大一点的节点 即:biggerNode
 * 然后biggerNode下面没右节点直接挂入右节点
 * biggerNode下面有右节点，直接挂入右节点，并把biggerNode历史的右节点，放到新节点的左节点
 * @author jijiahe
 * @version 1.0
 * @date 2022/8/30 14:03
 */
public class Title998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (val > root.val) {
            return new TreeNode(val, root, null);
        }
        TreeNode biggerNode = root;
        TreeNode nextNode = root.right;
        while (nextNode != null && nextNode.val > val) {
            biggerNode = nextNode;
            nextNode = nextNode.right;
        }
        if (nextNode == null) {
            biggerNode.right = new TreeNode(val);
        } else {
            biggerNode.right = new TreeNode(val, nextNode, null);
        }
        return root;
    }
    class TreeNode {
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
}
