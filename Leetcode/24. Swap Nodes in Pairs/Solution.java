/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	//使用以下测试用例：
	//[],[1],[1,2],[1,2,3],[1,2,3,4]
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(0);
        ListNode n0, n1, n2;
        pre.next = n1 = head;
        n0 = n2 = pre;
        //while里面的循环条件针对节点个数为奇数和偶数的情况
        while (n1 != null && n1.next != null) {
        	n2 = n1.next;
        	n0.next = n2;
        	n1.next = n2.next;
        	n2.next = n1;
        	n0 = n1;
        	n1 = n1.next;
        }
        return pre.next;
    }
}