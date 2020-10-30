import java.util.*;

public class Solution {
    /**
     * Connect node.
     * 层次遍历同时串联节点
     * Time complexity: O(N)
     * Space complexity: O(1)
     *
     * @param root the root
     * @return the node
     */
    public Node connect(Node root) {
        Node r = root;
        while (r != null) {
            Node dummy = new Node(0);
            Node nextLevelHead = dummy;
            while (r != null) {
                if (r.left != null) {
                    nextLevelHead.next = r.left;
                    nextLevelHead = nextLevelHead.next;
                }
                if (r.right != null) {
                    nextLevelHead.next = r.right;
                    nextLevelHead = nextLevelHead.next;
                }
                r = r.next;
            }
            r = dummy.next;
        }
        return root;
    }
}