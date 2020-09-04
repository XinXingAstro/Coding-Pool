import java.util.Arrays;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode build(int[] porder, int ps, int pe, int[] iorder, int is, int ie) {
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(porder[ps]);
        int index = find(porder[ps]);
        int left = index - is;
        int right = ie - index;
        root.left = build(porder, ps+1, ps+left, iorder, is, is+left-1);
        root.right = build(porder, pe-right+1, pe, iorder, ie-right+1, ie);
        return root;
    }
}
