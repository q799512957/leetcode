package everyday;

/**
 * 两数相加
 * @author jijiahe
 * @version 1.0
 * @date 2022/9/5 15:30
 */
public class Title2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = null;
        ListNode root = null;
        ListNode cur = null;
        boolean flag = false;
        while (l1 != null || l2 != null || flag){
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + (flag ? 1 : 0);
            flag = sum >= 10;
            cur = new ListNode(sum % 10);
            if (pre == null) {
                root = cur;
            } else {
                pre.next = cur;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            pre = cur;
        }
        return root;
    }
}
