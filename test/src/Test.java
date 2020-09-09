import java.util.*;

public class Test {
    public Queue<Integer> preOrder = new ArrayDeque<>();
    public Queue<Integer> postOrder = new ArrayDeque<>();
    public ArrayDeque<Integer> postReverse = new ArrayDeque<>();

    public void dfs(TreeNode root) {
        if (root == null) return;
        preOrder.offer(root.val);
        dfs(root.left);
        dfs(root.right);
        postOrder.offer(root.val);
        postReverse.push(root.val);
    }
}
