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
//        new Solution().reverseBetween(a, 1, 10);
        int[] n1 = {1,2};
        int[] n2 = {3,4};
        System.out.println(new Solution().findMedianSortedArrays(n1, n2));
        /*String s = "226";
        System.out.println(new Solution().numDecodings(s));*/
    }
}