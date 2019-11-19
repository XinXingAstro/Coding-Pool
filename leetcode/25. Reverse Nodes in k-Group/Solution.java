/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	//速度很快，空间占用比较多
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode[] node = new ListNode[k + 1];
        node[1] = pre;
        while (move(node, k))
        	reverse(node, k);
        return pre.next;
    }
    public void reverse(ListNode[] node, int k) {
        if (node[k] == null) return;
    	node[0].next = node[k];
    	node[1].next = node[k].next;
    	for (int i = 2; i <= k; i++) {
    		node[i].next = node[i - 1];
    	}
    }
    public boolean move(ListNode[] node, int k) {
    	if (node[1] == null) return false;
    	node[0] = node[1];
    	node[1] = node[1].next;
    	for (int i = 2; i <= k; i++) {
    		if (node[i - 1] == null) return false;
    		node[i] = node[i - 1].next;
    	}
    	return true;
    }
}