public class Solution {
    /**
     * Find median sorted arrays double.
     * Test case: [], [1] = 1.0; [3], [-2,-1] = -1.0;
     * 在统计学中，中位数是用来将集合划分为两个长度相等的子集，
     * 其中一个子集中的所有元素全都大于另一个子集中的所有元素。
     * 题解：https://www.cnblogs.com/grandyang/p/4465932.html
     *
     * @param nums1 the nums 1
     * @param nums2 the nums 2
     * @return the double
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length, N2 = nums2.length;
        if (N1 < N2) return findMedianSortedArrays(nums2, nums1); //确保第二个数组是短的那个
        int lo = 0, hi = N2 * 2; //在0~2N2范围内搜索，确保算法复杂度是O(log(2*min(N1, N2)))
        while (lo <= hi) {
            int mid2 = (lo + hi) / 2; //尝试拆分nums2
            int mid1 = N1 + N2 - mid2; //计算出nums1的切分点
            double L1 = (mid1 == 0) ? Double.MIN_VALUE : nums1[(mid1-1)/2];
            double L2 = (mid2 == 0) ? Double.MIN_VALUE : nums2[(mid2-1)/2];
            double R1 = (mid1 == N1*2) ? Double.MAX_VALUE : nums1[mid1/2];
            double R2 = (mid2 == N2*2) ? Double.MAX_VALUE : nums2[mid2/2];
            if (L1 > R2) lo = mid2 + 1; //nums1的左半区太大了，
            else if (L2 > R1) hi = mid2 - 1;
            else return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
        }
        return -1;
    }
}