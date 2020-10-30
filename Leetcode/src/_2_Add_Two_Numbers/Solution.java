package _2_Add_Two_Numbers;

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
	//这道题异常情况比较多使用以下Test case
	//l1={9,9},l2={1}
	//l1={},l2={0,1}
	//l1={0,1},l2={0,1,2}
	//Time complexity: O(max(n,m))
	//Space complexity: O(max(n,m))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        int value = 0;
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1 != null || l2 != null || carry) {
        	if (carry) {
        		value = 1;
        		carry = false;
        	} else value = 0;
        	if (l1 != null) {
        		value += l1.val;
        		l1 = l1.next;
        	}
        	if (l2 != null) {
        		value += l2.val;
        		l2 = l2.next;
        	} 
        	if (value >= 10) {
        		carry = true;
        		value -= 10;
        	}
        	head.next = new ListNode(value);
        	head = head.next;
        }
        return node.next;
    }
}