import common.ListNode;

public class Solution {
    /**
     * Delete duplicates list node.
     * 跟数组中移除重复数字原理一样，参考数组中移除重复数字程序模板。
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param head the head
     * @return the list node
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head.next, pre = head;
        while (fast != null) {
            if (fast.val > pre.val) {
                pre.next = fast;
                pre = pre.next;
            }
            fast = fast.next;
        }
        pre.next = fast;
        return dummy.next;
    }
}
