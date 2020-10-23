public class Solution {
    /**
     * Merge.
     * 因为nums1相当于后面有空间，
     * 所以从后向前依次找出两个数组中最大的元素放到nums1中既可。
     *
     *
     * @param nums1 the nums 1
     * @param m     the m
     * @param nums2 the nums 2
     * @param n     the n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1, p2 = n-1, p = m+n-1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        while (p1 >= 0) nums1[p--] = nums1[p1--];
        while (p2 >= 0) nums1[p--] = nums2[p2--];
    }
}
