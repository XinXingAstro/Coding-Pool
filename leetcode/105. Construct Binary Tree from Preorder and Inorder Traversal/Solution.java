public class Solution {
    /**
     * Build tree tree node.
     * 比较容易理解的算法，但是速度慢
     *
     * @param preorder the preorder
     * @param inorder  the inorder
     * @return the tree node
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length-1, preorder, inorder);
    }
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length-1 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) inIndex = i;
        }
        root.left = helper(preStart+1, inStart, inIndex-1, preorder, inorder);
        root.right = helper(preStart+(inIndex-inStart+1), inIndex+1, inEnd, preorder, inorder);
        return root;
    }

    /**
     * Build tree tree node.
     * 不容易理解的算法，但是速度快
     *
     * @param preorder the preorder
     * @param inorder  the inorder
     * @return the tree node
     */
    private int preIndex = 0;
    private int inIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildHelper(preorder, inorder, Integer.MAX_VALUE);
    }
    private TreeNode buildHelper(int[] preorder, int[] inorder, int rootVal) {
        if (inIndex == inorder.length || inorder[inIndex] == rootVal) return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;
        root.left = buildHelper(preorder, inorder, root.val);
        inIndex++;
        root.right = buildHelper(preorder, inorder, rootVal);
        return root;
    }
}