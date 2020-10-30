import common.ListNode;

public class Solution {
    /**
     * Reverse between list node.
     * 挂葡萄法
     * 先找到第n+1个元素，然后将需要翻转的元素一个一个取下来挂上，
     * 期间需要指针顺着葡萄串移动。模板代码
     * Time complexity：O(n)
     * Space complexity: O(1)
     *
     * @param head the head
     * @param m    the m
     * @param n    the n
     * @return the list node
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p0 = dummy, p1 = head;
        for (int i = 0; i < m-1; i++) {
            p0 = p0.next; //p0指向需要翻转的第一个元素前面一个元素
            p1 = p1.next; //p1指向需要翻转的第一个元素
        }
        p0.next = null; //先将前面的元素断开避免干扰
        ListNode p2 = p1.next, p3 = p1;
        for (int i = 0; i < n-m+1; i++) p3 = p3.next; //p3指向需要翻转最后一个元素的后一个元素，葡萄根
        for (int i = 0; i < n-m+1; i++) {
            p1.next = p3; //将p1指向的元素摘下来挂到根上
            p3 = p1; //葡萄根向下移动
            p1 = p2; //p1向需要翻转的后一个元素移动
            if (p2 != null) p2 = p2.next; //如果后面还有元素则p2向后移动
        }
        p0.next = p3; //翻转好以后将这两段接起来
        return dummy.next;
    }
}
