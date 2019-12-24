public class Solution {
    /**
     * Build tree tree node.
     * 模板代码需要背诵
     *
     * @param inorder   the inorder
     * @param postorder the postorder
     * @return the tree node
     */
    public int inIndex;   // index of inorder array
    public int postIndex; // index of postorder array
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inIndex = inorder.length - 1;
        postIndex = postorder.length - 1;
        return buildTree(inorder, postorder, null);
    }
    private TreeNode buildTree(int[] inorder, int[] postorder, TreeNode end) {
        if (postIndex < 0) return null;
        // create root node
        TreeNode r = new TreeNode(postorder[postIndex]);
        postIndex--;
        // if right node exist, create right subtree
        if (inorder[inIndex] != r.val) r.right = buildTree(inorder, postorder, r);
        inIndex--;
        // if left node exist, create left subtree
        if ((end == null) || (inorder[inIndex] != end.val)) r.left = buildTree(inorder, postorder, end);
        return r;
    }
}