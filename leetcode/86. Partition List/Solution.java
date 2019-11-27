public class Solution {
    /**
     * Partition list node.
     * 遍历链表，遇到比x小的元素，直接将节点换到前面,
     * 还有一种解法是用分成两个链表最后拼到一起，貌似更简单
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param head the head
     * @param x    the x
     * @return the list node
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode f = head, pf = dummy, s = dummy;
        while (f != null) {
            if (f.val < x && s.next != f) {
                pf.next = f.next;
                f.next = s.next; //如果s.next == f, 则会形成环，所以上面if语句中加了s.next!=f判断
                s.next = f;
                s = s.next;
                f = pf.next;
            } else {
                if (s.next == f && f.val < x) s = s.next;
                f = f.next;
                pf = pf.next;
            }
        }
        return dummy.next;
    }

    /**
     * Partition list node.
     * 新定义两个头pbh(preBigHead)和psh(preSmallHead)
     * pbh用户穿大于x的节点，psh用于穿小于x的节点，
     * 穿完以后将bh链表的结尾置为null(不然会生成环)，
     * 最后将两个链表连到一起后返回，比逐个节点调换简单很多。
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param head the head
     * @param x    the x
     * @return the list node
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode psh = new ListNode(0);
        ListNode pbh = new ListNode(0);
        ListNode sh = psh, bh = pbh, node = head;
        while (node != null) {
            if (node.val < x) {
                sh.next = node;
                sh = sh.next;
            } else {
                bh.next = node;
                bh = bh.next;
            }
            node = node.next;
        }
        bh.next = null;
        sh.next = pbh.next;
        return psh.next;
    }
}
