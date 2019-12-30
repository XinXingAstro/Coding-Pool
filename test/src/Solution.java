import java.util.*;

public class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        connect(root.left).next = connect(root.right);
        return root;
    }
}