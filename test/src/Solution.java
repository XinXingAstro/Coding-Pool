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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        // find Key node
        TreeNode p = root;
        TreeNode parent = root;
        while (p.val != key) {
            if (key > p.val) {
                parent = p;
                p = p.right;
            }
            else if (key < p.val) {
                parent = p;
                p = p.left;
            }
        }
        // delete p
        if (p.left == null && p.right == null) {
            if (parent.val > p.val) parent.left = null;
            else parent.right = null;
        } else if (p.right == null) {
            if (parent.val > p.val) parent.left = p.left;
            else parent.right = p.left;
        } else if (p.left == null) {
            if (parent.val > p.val) parent.left = p.right;
            else parent.right = p.right;
        } else {
            TreeNode t = p.right, tparent = null;
            while (t.left != null) {
                tparent = t;
                t = t.left;
            }
            p.val = t.val;
            if (tparent != null) tparent.left = t.right;
            else p.right = t.right;
        }
        return root;
    }
}