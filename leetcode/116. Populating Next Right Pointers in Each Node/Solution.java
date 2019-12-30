import java.util.*;

public class Solution {
    /**
     * Connect node.
     * 使用队列进行树的层次遍历，遍历过程中连接节点。
     * Time complexity: O(N)
     * Space complexity: O(N)
     * 不符合题目空间复杂度O(1)的要求，尝试其他解法。
     *
     * @param root the root
     * @return the node
     */
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int len = q.size();
            Node pre = null, cur = null;
            for (int i = 0; i < len; i++) {
                cur = q.poll();
                cur.next = pre;
                pre = cur;
                if (cur.right != null) q.offer(cur.right);
                if (cur.left != null) q.offer(cur.left);
            }
        }
        return root;
    }
}