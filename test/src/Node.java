public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(final int _val) {
        val = _val;
    }

    public Node(final int _val, final Node _left, final Node _right, final Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _right;
    }
}
