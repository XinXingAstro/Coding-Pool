import common.ListNode;

/**
 * Definition for singly-linked list.
 * public class common.ListNode {
 *     int val;
 *     common.ListNode next;
 *     common.ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * Rotate right list node.
     * test case:
     * [0,1,2],4;
     * [],1;
     * [1,2,3],2000000000;
     * [1,2],0;
     * 异常情况是链表问题的主要考点。
     * 移动节点，拆分链表时要用dummy节点做。
     *
     * @param head the head
     * @param k    the k
     * @return the list node
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode cur = head, pre = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = 1;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        k %= len;
        cur = head;
        for (int i = k; i > 0; i--) {
            pre = pre.next;
        }
        while (pre.next != null) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = dummy.next;
        dummy.next = cur.next;
        cur.next = null;
        return dummy.next;
    }
}
