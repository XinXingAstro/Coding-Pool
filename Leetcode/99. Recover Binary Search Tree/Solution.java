/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode first;
    public TreeNode second;
    public TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return;
    }
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (first == null && pre.val > root.val) first = pre;
        if (first != null && pre.val > root.val) second = root;
        pre = root;
        inorder(root.right);
    }
}