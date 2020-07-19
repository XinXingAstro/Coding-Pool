/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    public Stack<Integer> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        inorder(root);
    }

    public void inorder(TreeNode root) {
        if (root == null) return ;
        inorder(root.right);
        stack.push(root.val);
        inorder(root.left);
    }

    /** @return the next smallest number */
    public int next() {
        return stack.pop();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */