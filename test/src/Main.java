public class Main {
    public static void main(String[] args) {
/*        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        ListNode h = new ListNode(8);
        ListNode i = new ListNode(9);
        ListNode j = new ListNode(10);
        a.next = b; b.next = c; c.next = d; d.next = e; e.next = f; f.next = g; g.next = h;
        h.next = i; i.next = j;*/
        /*TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        a.left = b; a.right = c; b.left = d; b.right = e; *//*c.left = f; *//*c.right = g;
        System.out.println(new Solution().rob(a));*/
//        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
        /*String s = "226";
        System.out.println(new Solution().numDecodings(s));*/
//        System.out.println(new Test().test("123"));

        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(7);
        a.left = b; a.right = c; b.left = d; b.right = e; c.right = f;
        new Solution().deleteNode(a, 3);
    }
}
