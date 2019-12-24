public class Solution {


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