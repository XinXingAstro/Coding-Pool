/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode ans = head;
        int n = lists.length, min = Integer.MAX_VALUE, index = -1, empty = 0;
        while (empty < n) {
	        for (int i = 0; i < n; i++) {
	        	if (lists[i] != null && lists[i].val < min) {
	        		min = lists[i].val;
	        		index = i;
	        	} else if (lists[i] == null) {
	        		empty++;
	        	}
	        }
            if (empty < n) {
                head.next = lists[index];
                head = head.next;
                lists[index] = lists[index].next;
                min = Integer.MAX_VALUE;
                index = -1;
                empty = 0;
            }
        }
        return ans.next;
    }
}