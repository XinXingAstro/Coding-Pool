public class Main {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
//        ListNode c = new ListNode(3);
//        ListNode d = new ListNode(4);
//        ListNode e = new ListNode(5);
//        ListNode f = new ListNode(6);
//        ListNode g = new ListNode(7);
//        ListNode h = new ListNode(8);
//        ListNode i = new ListNode(9);
//        ListNode j = new ListNode(10);
//        a.next = b; b.next = c; c.next = d; d.next = e; e.next = f; f.next = g; g.next = h;
//        h.next = i; i.next = j;
        a.left = b;
        System.out.println(new Solution().isValidBST(a));
//        System.out.println(new Solution().partition(a, 3));
        /*String s = "226";
        System.out.println(new Solution().numDecodings(s));*/
    }
}
