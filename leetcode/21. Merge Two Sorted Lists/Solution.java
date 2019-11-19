/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	//穿针引线法
	//Time complexity: O(n)
	//Space complexity: O(1)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode ans = head, node1 = l1, node2 = l2;
        while(node1 != null && node2 != null) {
        	if (node1.val < node2.val) {
        		head.next = node1;
        		node1 = node1.next;
        		head = head.next;
        	} else {
        		head.next = node2;
        		node2 = node2.next;
        		head = head.next;
        	}
        }
        if (node1 != null) head.next = node1;
        if (node2 != null) head.next = node2;
        return ans.next;
    }
}