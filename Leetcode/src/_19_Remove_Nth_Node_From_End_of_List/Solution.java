import common.ListNode;

/**
 * Definition for singly-linked list.
 * public class common.ListNode {
 *     int val;
 *     common.ListNode next;
 *     common.ListNode(int x) { val = x; }
 * }
 */
class Solution {
	//Three Move Pointer
	//注意三种异常情况：
	//1.链表只有一个节点
	//2.删除首个节点
	//3.删除末尾节点
	//Time complexity: O(n)
	//Space complexity: O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if (head.next == null) return null; //如果只有一个节点，返回null
        ListNode target, tail;
        target = tail = head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        for (int i = 1; i < n; i++) {
        	tail = tail.next;
        }
        while (tail.next != null) {
        	tail = tail.next;
        	target = target.next;
        	pre = pre.next;
        }
        if (target == head) {
        	return head.next; //如果删除首个节点，直接返回head.next
        }
        else {
        	pre.next = target.next;
        	return head;
        }
    }
}