public class Solution {
    /**
     * Delete duplicates list node.
     * 链表题都是考察异常情况处理
     * Test case： [], [1,1,1], [1,1,1,2], [1,2,3,3,3], [1,1,1,2,3,3,3], [1,2,2,2,3]
     * 也可以使用两个指针完成，见下面一种解法。
     *
     * @param head the head
     * @return the list node
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, dist = head, fast = head.next;
        while (fast != null) {
            if (dist.val == fast.val) {
                fast = fast.next;
            } else {
                if (dist.next != fast) {
                    dist = fast;
                    pre.next = dist;
                    fast = fast.next;
                } else {
                    fast = fast.next;
                    dist = dist.next;
                    pre = pre.next;
                }
            }
        }
        if (dist.next != fast) {
            dist = fast;
            pre.next = dist;
        }
        return dummy.next;
    }

    /**
     * Delete duplicates 1 list node.
     * 上面算法只用两个指针的解法
     *
     * @param head the head
     * @return the list node
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, fast = head.next;
        while (fast != null) {
            //如果pre的下一个数和fast指的数相同，fast向后移动
            if (pre.next.val == fast.val) {
                fast = fast.next;
            } else { //如果不同
                // 如过pre的下下个不是fast，说明需要删除重复接地
                if (pre.next.next != fast) {
                    pre.next = fast;
                    fast = fast.next;
                } else { //如果下下个就是fast，则只向前移动。
                    fast = fast.next;
                    pre = pre.next;
                }
            }
        }
        if (pre.next.next != fast) pre.next = fast;
        return dummy.next;
    }
}
