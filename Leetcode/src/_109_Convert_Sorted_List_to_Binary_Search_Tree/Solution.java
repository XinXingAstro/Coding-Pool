import common.ListNode;

import java.util.*;

public class Solution {
    /**
     * Find mid list node.
     * 递归方式建树，模板代码
     * Time complexity：O(NlogN)
     * Space complexity: O(logN)
     * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/solution/
     *
     * @param head the head
     * @return the list node
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode pre = null;
        ListNode l1 = head;
        ListNode l2 = head;
        while (l2 != null && l2.next != null) {
            pre = l1;
            l1 = l1.next;
            l2 = l2.next.next;
        }
        pre.next = null;
        TreeNode res = new TreeNode(l1.val);
        res.left = sortedListToBST(head);
        res.right = sortedListToBST(l1.next);
        return res;
    }

    /**
     * Sorted list to bst tree node.
     * 先将链表转换为list，然后再建树
     * Time complexity: O(N)
     * Space complexity: O(N)
     *
     * @param head the head
     * @return the tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        // Form an array out of the given linked list and then
        // use the array to form the BST
        this.mapListToValues(head);
        //Convert the array to
        return convertListToBST(0, this.values.size()-1);
    }
    private List<Integer> values;
    public Solution() {
        this.values = new ArrayList<Integer>();
    }
    private void mapListToValues(ListNode head) {
        while (head != null) {
            this.values.add(head.val);
            head = head.next;
        }
    }
    private TreeNode convertListToBST(int left, int right) {
        // Invalid case
        if (left > right) return null;
        //Middle element forms the root.
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(this.values.get(mid));
        // Base case for when there is only one element left in the array
        if (left == right) return node;
        // Recursively form BST on the two halves
        node.left = convertListToBST(left, mid-1);
        node.right = convertListToBST(mid+1, right);
        return node;
    }
}