/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode[] node = new ListNode[k + 1];
        node[1] = pre;
        while (node[0] != null && node[0].next != null) {
	        //move
	        node[0] = node[1];
	        node[1] = node[1].next;
	        for (int i = 2; i <= k; i++) {
	        	node[i] = node[i - 1].next;
	        }
	        //reverse
	        node[0].next = node[k];
	        node[1].next = node[k].next;
	        for (int j = 1; j < (k - 1); j++) {
	        	node[j + 1].next = node[j];
	        }
        }
        return pre.next;
    }
}