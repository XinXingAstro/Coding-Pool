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

    /**
     * Connect node.
     * 迭代方法进行连接
     * Time complexity: O(N)
     * Space complexity: O(1)
     *
     * @param root the root
     * @return the node
     */
    public Node connect(Node root) {
        Node r = root;
        while (r != null) {
            Node cur = r;
            while (cur != null) {
                if (cur.left != null) cur.left.next = cur.right;
                if (cur.right != null && cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            r = r.left;
        }
        return root;
    }

    /**
     * Connect node.
     * 递归方式进行连接, 先根遍历。
     * Time complexity: O(N)
     * Space complexity: O(1)
     *
     * @param root the root
     * @return the node
     */
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) {
            root.left.next = root.right; //将root左右子节点连接
            if (root.next != null)
                root.right.next = root.next.left; //将两个子树连接
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}